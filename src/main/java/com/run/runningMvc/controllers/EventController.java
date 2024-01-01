package com.run.runningMvc.controllers;

import com.run.runningMvc.Dtos.EventDto;
import com.run.runningMvc.models.Event;
import com.run.runningMvc.services.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EventController {
    private EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }


    @GetMapping("/events")
    public String eventList(Model model){
        List<EventDto> events = eventService.findAllEvents();
        model.addAttribute("events", events);
        return "events-all";
    }
    @GetMapping("/events/{clubId}/create")
    public String newEventForm(@PathVariable(name = "clubId") int clubId, Model model){
        EventDto event = new EventDto();
        model.addAttribute("event", event);
        model.addAttribute("clubId", clubId);
        return "events-create";
    }
    @PostMapping("/events/{clubId}")
    public String createEvent(@PathVariable("clubId") int clubId,
                              @Valid @ModelAttribute("event") EventDto event,
                              BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "events-create";
        }
        eventService.saveEvent(clubId, event);
        return "redirect:/clubs/" + clubId;
    }
    @GetMapping("/events/{eventId}")
    public String viewEvent(@PathVariable("eventId") int eventId, Model model){
        EventDto eventDto = eventService.findEventById(eventId);
        model.addAttribute("event", eventDto);
        return "events-view";
    }
    @GetMapping("/events/{eventId}/edit")
    public String editEventForm(@PathVariable("eventId") int eventId, Model model){
        EventDto eventDto = eventService.findEventById(eventId);
        model.addAttribute("event", eventDto);
        return "events-edit";
    }

    @PostMapping("/events/{eventId}/edit")
    public String editEvent(@PathVariable("eventId") int eventId,
                            @Valid @ModelAttribute("event") EventDto eventDto,
                            BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("event", eventDto);
            return "events-edit";
        }
        EventDto oldEvent = eventService.findEventById(eventId);
        eventDto.setClub(oldEvent.getClub());
        eventDto.setId(eventId);
        eventService.editEvent(eventDto);
        return "redirect:/events";
    }
    @GetMapping("/events/{eventId}/delete")
    public String deleteEvent(@PathVariable("eventId") int eventId){
        eventService.deleteEventById(eventId);
        return "redirect:/events";
    }
}



























