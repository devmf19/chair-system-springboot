package com.devmf.chairSystem.service.interfaces;

import com.devmf.chairSystem.dto.EventDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IEventService {
    List<EventDto> getEvents();

    EventDto getEventById(long id);

    void saveEvent(EventDto eventDto);

    void updateEvent(EventDto eventDto);

    void deleteEvent(EventDto eventDto);
}
