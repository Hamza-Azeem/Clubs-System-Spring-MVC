package com.run.runningMvc.mappers;

import com.run.runningMvc.Dtos.ClubDto;
import com.run.runningMvc.models.Club;

import java.util.stream.Collectors;

import static com.run.runningMvc.mappers.EventMapper.mapToEventDto;

public class ClubMapper {
    public static Club mapToClub(ClubDto clubDto) {
        Club club = Club.builder()
                .id(clubDto.getId())
                .content(clubDto.getContent())
                .createdOn(clubDto.getCreatedOn())
                .photoUrl(clubDto.getPhotoUrl())
                .title(clubDto.getTitle())
                .updatedOn(clubDto.getUpdatedOn())
                .build();
        return club;
    }

    public static ClubDto mapToClubDto(Club club){
        ClubDto clubDto = ClubDto.builder()
                .id(club.getId())
                .content(club.getContent())
                .title(club.getTitle())
                .createdOn(club.getCreatedOn())
                .photoUrl(club.getPhotoUrl())
                .updatedOn(club.getUpdatedOn())
                .events(club.getEvents().stream().map((event) -> mapToEventDto(event)).collect(Collectors.toList()))
                .build();
        return clubDto;
    }
}
