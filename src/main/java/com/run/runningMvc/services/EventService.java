package com.run.runningMvc.services;

import com.run.runningMvc.Dtos.EventDto;

import java.util.List;

public interface EventService {

    void saveEvent(int clubId, EventDto event);

    EventDto findEventById(int eventId);

    List<EventDto> findAllEvents();

    void editEvent(EventDto eventDto);

    void deleteEventById(int eventId);
}
