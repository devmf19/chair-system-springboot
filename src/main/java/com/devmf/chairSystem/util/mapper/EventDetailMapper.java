package com.devmf.chairSystem.util.mapper;

import com.devmf.chairSystem.dto.EventDetailDto;
import com.devmf.chairSystem.model.EventDetail;
import com.devmf.chairSystem.service.implementation.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventDetailMapper {
    private final ProductMapper productMapper = new ProductMapper();
    @Autowired
    private EventService eventService;

    public EventDetailDto entityToDto(EventDetail eventDetail) {
        return eventDetail == null
                ? null
                : new EventDetailDto(
                eventDetail.getId(),
                eventDetail.getAmount(),
                eventDetail.getPrice(),
                eventDetail.getEvent().getId(),
                productMapper.entityToDto(eventDetail.getProduct())
        );
    }

    public EventDetail dtoToEntity(EventDetailDto eventDetailDto) {
        return eventDetailDto == null
                ? null
                : new EventDetail(
                eventDetailDto.getId(),
                eventDetailDto.getAmount(),
                eventDetailDto.getPrice(),
                eventService.getEventById(eventDetailDto.getEventId()),
                productMapper.dtoToEntity(eventDetailDto.getProduct())
        );
    }
}
