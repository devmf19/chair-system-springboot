package com.devmf.chairSystem.service.interfaces;

import com.devmf.chairSystem.dto.EventDetailDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface IEventDetailService {
    public List<EventDetailDto> getEventDetails();

    public Optional<EventDetailDto> getEventDetailById(long id);

    public void saveEventDetail(EventDetailDto eventDetailDto);

    public void updateEventDetail(EventDetailDto eventDetailDto);

    public void deleteEventDetail(EventDetailDto eventDetailDto);
}
