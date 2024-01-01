package com.run.runningMvc.services.impl;

import com.run.runningMvc.Dtos.ClubDto;
import com.run.runningMvc.models.Club;
import com.run.runningMvc.repositories.ClubRepository;
import com.run.runningMvc.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.run.runningMvc.mappers.ClubMapper.mapToClub;
import static com.run.runningMvc.mappers.ClubMapper.mapToClubDto;

@Service
public class ClubServiceImpl implements ClubService {
    private ClubRepository clubRepository;

    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream().map((club) -> mapToClubDto(club)).collect(Collectors.toList());
    }

    @Override
    public Club saveClub(ClubDto clubDto){
        Club club = mapToClub(clubDto);
       return clubRepository.save(club);
    }

    @Override
    public ClubDto findById(int clubId) {
        Club club = clubRepository.findById(clubId).get();
        return mapToClubDto(club);
    }

    @Override
    public void update(ClubDto clubDto) {
        Club club = mapToClub(clubDto);
        clubRepository.save(club);
    }

    @Override
    public void deleteClub(ClubDto clubDto) {
        Club club = mapToClub(clubDto);
        clubRepository.delete(club);
    }

    @Override
    public List<ClubDto> searchClubs(String query) {
        List<Club> clubs = clubRepository.searchClubs(query);
        return clubs.stream().map((club) -> mapToClubDto(club)).collect(Collectors.toList());
    }


}
