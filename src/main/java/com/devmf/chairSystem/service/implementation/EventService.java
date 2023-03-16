package com.devmf.chairSystem.service.implementation;

import com.devmf.chairSystem.dto.EventDto;
import com.devmf.chairSystem.repository.EventRepository;
import com.devmf.chairSystem.service.interfaces.IEventService;
import com.devmf.chairSystem.service.mapping.EventMap;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventService implements IEventService {

    @Autowired
    private EventRepository eventRepository;

    private EventMap eventMap = new EventMap();

    @Override
    public List<EventDto> getEvents() {
        return eventRepository.findAll()
                .stream()
                .map(eventMap::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EventDto> getEventById(long id) {
        return Optional.of(
                eventMap.entityToDto(
                        eventRepository.findById(id).get()
                )
        );
    }

    @Override
    public void saveEvent(EventDto eventDto) {
        eventRepository.save(
                eventMap.dtoToEntity(eventDto)
        );
    }

    @Override
    public void updateEvent(EventDto eventDto) {
        eventRepository.save(
                eventMap.dtoToEntity(eventDto)
        );
    }

    @Override
    public void deleteEvent(EventDto eventDto) {
        eventRepository.delete(
                eventMap.dtoToEntity(eventDto)
        );
    }
}
