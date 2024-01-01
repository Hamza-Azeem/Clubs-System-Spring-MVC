package com.run.runningMvc.services;

import com.run.runningMvc.Dtos.ClubDto;
import com.run.runningMvc.models.Club;

import java.util.List;


public interface ClubService {
    List<ClubDto> findAllClubs();

    Club saveClub(ClubDto club);

    ClubDto findById(int clubId);

    void update(ClubDto clubDto);

    void deleteClub(ClubDto clubDto);
    List<ClubDto> searchClubs(String query);
}
