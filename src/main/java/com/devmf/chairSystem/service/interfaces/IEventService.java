package com.devmf.chairSystem.service.interfaces;

import com.devmf.chairSystem.dto.EventDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface IEventService {
    public List<EventDto> getEvents();

    public Optional<EventDto> getEventById(long id);

    public void saveEvent(EventDto eventDto);

    public void updateEvent(EventDto eventDto);

    public void deleteEvent(EventDto eventDto);
}
