package com.devmf.chairSystem.Service.interfaces;

import com.devmf.chairSystem.model.EventDetail;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface IEventDetailService {
    public List<EventDetail> getEventDetails();

    public Optional<EventDetail> getEventDetailById(long id);

    public void saveEventDetail(EventDetail eventDetail);

    public void updateEventDetail(EventDetail eventDetail);

    public void deleteEventDetail(EventDetail eventDetail);
}
