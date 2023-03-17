package com.devmf.chairSystem.service.interfaces;

import com.devmf.chairSystem.dto.EventDetailDto;
import com.devmf.chairSystem.dto.EventDto;
import com.devmf.chairSystem.model.Event;
import com.devmf.chairSystem.model.EventDetail;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IEventDetailService {
    List<EventDetailDto> getAllEventDetails();

    EventDetailDto getEventDetailById(long id);

    List<EventDetailDto> findEventDetailByEvent(EventDto eventDto);


    void saveEventDetail(EventDetailDto eventDetailDto);

    void updateEventDetail(EventDetailDto eventDetailDto);

    void deleteEventDetail(EventDetailDto eventDetailDto);
}
