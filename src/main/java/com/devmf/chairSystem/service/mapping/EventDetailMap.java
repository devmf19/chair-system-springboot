package com.devmf.chairSystem.service.mapping;

import com.devmf.chairSystem.dto.EventDetailDto;
import com.devmf.chairSystem.model.EventDetail;
import org.springframework.stereotype.Component;

@Component
public class EventDetailMap {
    public EventDetailDto entityToDto(EventDetail eventDetail){
        EventDetailDto eventDetailDto = new EventDetailDto();

        eventDetailDto.setId(eventDetail.getId());
        eventDetailDto.setAmount(eventDetail.getAmount());
        eventDetailDto.setPrice(eventDetail.getPrice());
        eventDetailDto.setProductDto(new ProductMap().entityToDto(eventDetail.getProduct()));
        eventDetailDto.setEventDto(new EventMap().entityToDto(eventDetail.getEvent()));

        return  eventDetailDto;
    }

    public EventDetail dtoToEntity(EventDetailDto eventDetailDto){
        EventDetail eventDetail = new EventDetail();

        eventDetail.setId(eventDetailDto.getId());
        eventDetail.setAmount(eventDetailDto.getAmount());
        eventDetail.setPrice(eventDetailDto.getPrice());
        eventDetail.setProduct(new ProductMap().dtoToEntity(eventDetailDto.getProductDto()));
        eventDetail.setEvent(new EventMap().dtoToEntity(eventDetailDto.getEventDto()));

        return  eventDetail;
    }
}
