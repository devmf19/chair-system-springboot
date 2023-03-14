package com.devmf.chairSystem.Service.interfaces;

import com.devmf.chairSystem.model.Event;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface IEventService {
    public List<Event> getEvents();

    public Optional<Event> getEventById(long id);

    public void saveEvent(Event event);

    public void updateEvent(Event event);

    public void deleteEvent(Event event);
}
