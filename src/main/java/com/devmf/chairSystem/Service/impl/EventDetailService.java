package com.devmf.chairSystem.Service.impl;

import com.devmf.chairSystem.Service.interfaces.IEventDetailService;
import com.devmf.chairSystem.model.EventDetail;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EventDetailService implements IEventDetailService {
    @Override
    public List<EventDetail> getEventDetails() {
        return null;
    }

    @Override
    public Optional<EventDetail> getEventDetailById(long id) {
        return Optional.empty();
    }

    @Override
    public void saveEventDetail(EventDetail eventDetail) {

    }

    @Override
    public void updateEventDetail(EventDetail eventDetail) {

    }

    @Override
    public void deleteEventDetail(EventDetail eventDetail) {

    }
}
