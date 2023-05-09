package com.devmf.chairSystem.service.interfaces;

import com.devmf.chairSystem.dto.EventDetailDto;
import org.springframework.stereotype.Component;

@Component
public interface IEventDetailService {
    EventDetailDto getEventDetailById(long id);

    void saveEventDetail(EventDetailDto eventDetailDto);

    void updateEventDetail(EventDetailDto eventDetailDto);

    void deleteEventDetail(EventDetailDto eventDetailDto);
}
