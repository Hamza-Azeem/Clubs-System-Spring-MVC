package com.run.runningMvc.mappers;

import com.run.runningMvc.Dtos.EventDto;
import com.run.runningMvc.models.Event;

public class EventMapper {
    public static EventDto mapToEventDto(Event event) {
        EventDto eventDto = EventDto.builder()
                .name(event.getName())
                .createdOn(event.getCreatedOn())
                .endTime(event.getEndTime())
                .id(event.getId())
                .photoUrl(event.getPhotoUrl())
                .startTime(event.getStartTime())
                .type(event.getType())
                .updatedOn(event.getUpdatedOn())
                .club(event.getClub())
                .build();
        return eventDto;
    }

    public static Event mapToEvent(EventDto eventDto){
        return Event.builder()
                .id(eventDto.getId())
                .name(eventDto.getName())
                .endTime(eventDto.getEndTime())
                .startTime(eventDto.getStartTime())
                .createdOn(eventDto.getCreatedOn())
                .type(eventDto.getType())
                .photoUrl(eventDto.getPhotoUrl())
                .updatedOn(eventDto.getUpdatedOn())
                .club(eventDto.getClub())
                .build();
    }
}
