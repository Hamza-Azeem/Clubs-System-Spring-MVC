package com.run.runningMvc.services.impl;

import com.run.runningMvc.Dtos.EventDto;
import com.run.runningMvc.models.Club;
import com.run.runningMvc.models.Event;
import com.run.runningMvc.repositories.ClubRepository;
import com.run.runningMvc.repositories.EventRepository;
import com.run.runningMvc.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.run.runningMvc.mappers.EventMapper.mapToEvent;
import static com.run.runningMvc.mappers.EventMapper.mapToEventDto;

@Service
public class EventServiceImpl implements EventService {
    private EventRepository eventRepository;
    private ClubRepository clubRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository, ClubRepository clubRepository) {
        this.eventRepository = eventRepository;
        this.clubRepository = clubRepository;
    }

    @Override
    public void saveEvent(int clubId, EventDto eventDto) {
        Club club = clubRepository.findById(clubId).get();
        Event event = mapToEvent(eventDto);
        event.setClub(club);
        eventRepository.save(event);
    }

    @Override
    public EventDto findEventById(int eventId) {
        Event event = eventRepository.findById(eventId).get();
        return mapToEventDto(event);
    }

    @Override
    public List<EventDto> findAllEvents() {
        List<EventDto> eventDtos = eventRepository.findAll().stream().map(event -> mapToEventDto(event)).collect(Collectors.toList());
        return eventDtos;
    }

    @Override
    public void editEvent(EventDto eventDto) {
        Event event = mapToEvent(eventDto);
        eventRepository.save(event);
    }

    @Override
    public void deleteEventById(int eventId) {
        eventRepository.deleteById(eventId);
    }


}












