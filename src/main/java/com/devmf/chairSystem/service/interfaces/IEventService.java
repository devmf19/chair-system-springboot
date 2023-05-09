package com.devmf.chairSystem.service.interfaces;

import com.devmf.chairSystem.dto.EventDto;
import com.devmf.chairSystem.model.Event;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

@Component
public interface IEventService {
    List<EventDto> getEvents();

    Event getEventById(long id);

    void saveEvent(EventDto eventDto);

    void updateEvent(EventDto eventDto);

    void deleteEvent(EventDto eventDto);

    boolean validateEvent(EventDto eventDto);

    List<EventDto> getEventsBetween(Date initialDate, Date endDate);

    List<EventDto> getAllEventsByState(String state);
}
