package com.devmf.chairSystem.Service.impl;

import com.devmf.chairSystem.Service.interfaces.IEventService;
import com.devmf.chairSystem.model.Event;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EventService implements IEventService {
    @Override
    public List<Event> getEvents() {
        return null;
    }

    @Override
    public Optional<Event> getEventById(long id) {
        return Optional.empty();
    }

    @Override
    public void saveEvent(Event event) {

    }

    @Override
    public void updateEvent(Event event) {

    }

    @Override
    public void deleteEvent(Event event) {

    }
}
