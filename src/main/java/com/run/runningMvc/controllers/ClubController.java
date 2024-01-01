package com.run.runningMvc.controllers;

import com.run.runningMvc.Dtos.ClubDto;
import com.run.runningMvc.models.Club;
import com.run.runningMvc.services.ClubService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClubController {
    private ClubService clubService;

    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }
    @GetMapping("clubs")
    public String allClubs(Model model){
        List<ClubDto> clubDtos = clubService.findAllClubs();
        model.addAttribute("clubs", clubDtos);
        return "clubs-all";
    }

    @GetMapping("/clubs/new")
    public String newClubForm(Model model){
        Club club = new Club();
        model.addAttribute("club", club);
        return "clubs-create";
    }

    @PostMapping("/clubs/new")
    public String saveClub(@Valid @ModelAttribute("club") ClubDto club,
                           BindingResult result){
        if(result.hasErrors()){
            return "clubs-create";
        }
        clubService.saveClub(club);
        return "redirect:/clubs";
    }
    @GetMapping("/clubs/{clubId}/edit")
    public String editClubForm(@PathVariable int clubId, Model model){
        ClubDto clubDto = clubService.findById(clubId);
        model.addAttribute("club", clubDto);
        return "clubs-edit";
    }

    @PostMapping("/clubs/{clubId}/edit")
    public String editClub(@PathVariable int clubId,
                           @Valid @ModelAttribute("club") ClubDto clubDto,
                           BindingResult result){
        if(result.hasErrors()){
            return "clubs-edit";
        }
        clubDto.setId(clubId);
        clubService.update(clubDto);
        return "redirect:/clubs";
    }
    @GetMapping("/clubs/{clubId}")
    public String viewClub(@PathVariable int clubId, Model model){
        ClubDto clubDto = clubService.findById(clubId);
        model.addAttribute("club", clubDto);
        return "clubs-view";
    }
    @GetMapping("/clubs/{clubId}/delete")
    public String deleteClub(@PathVariable("clubId") int id){
        ClubDto clubDto = clubService.findById(id);
        clubService.deleteClub(clubDto);
        return "redirect:/clubs";
    }
    @GetMapping("/clubs/search")
    public String searchClubs(@RequestParam(value = "query") String query, Model model){
        List<ClubDto> clubDtos = clubService.searchClubs(query);
        model.addAttribute("clubs", clubDtos);
        return "clubs-all";
    }
}





















