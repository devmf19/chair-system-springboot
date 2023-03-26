package com.devmf.chairSystem.service.implementation;

import com.devmf.chairSystem.dto.EventDto;
import com.devmf.chairSystem.repository.EventRepository;
import com.devmf.chairSystem.service.interfaces.IEventService;
import com.devmf.chairSystem.util.mapper.EventMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EventService implements IEventService {

    private EventRepository eventRepository;

    private EventMapper eventMapper;

    @Override
    public List<EventDto> getEvents() {
        return eventRepository.findAll()
                .stream()
                .map(eventMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public EventDto getEventById(long id) {
        return eventRepository.findById(id)
                .map(eventMapper::entityToDto)
                .orElse(null);
    }

    @Override
    public EventDto getEventByState(String state) {
        return eventRepository.findByState(state)
                .map(eventMapper::entityToDto)
                .orElse(null);
    }

    @Override
    public void saveEvent(EventDto eventDto) {
        eventRepository.save(
                eventMapper.dtoToEntity(eventDto)
        );
    }

    @Override
    public void updateEvent(EventDto eventDto) {
        eventRepository.save(
                eventMapper.dtoToEntity(eventDto)
        );
    }

    @Override
    public void deleteEvent(EventDto eventDto) {
        eventRepository.delete(
                eventMapper.dtoToEntity(eventDto)
        );
    }

    @Override
    public boolean validateEvent(EventDto eventDto) {
        return eventDto == null;
    }

    @Override
    public List<EventDto> getEventsBetween(Date initialDate, Date endDate) {
        return eventRepository.findEventsBetween(initialDate, endDate)
                .stream()
                .map(eventMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EventDto> getAllEventsByResolved(int resolved) {
        return eventRepository.findAllByResolved(resolved)
                .stream()
                .map(eventMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EventDto> getAllEventsByState(String state) {
        return eventRepository.findAllByState(state)
                .stream()
                .map(eventMapper::entityToDto)
                .collect(Collectors.toList());
    }


}
