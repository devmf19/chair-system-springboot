package com.devmf.chairSystem.util.mapper;

import com.devmf.chairSystem.dto.EventDto;
import com.devmf.chairSystem.model.Event;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {

    public EventDto entityToDto(Event event) {
        if(event == null )
            return null;

        EventDto eventDto = new EventDto();
        eventDto.setId(event.getId());
        eventDto.setInitialDate(event.getInitialDate());
        eventDto.setEndDate(event.getEndDate());
        eventDto.setPayment(event.getPayment());
        eventDto.setObservation(event.getObservation());
        eventDto.setResolved(event.getResolved());
        eventDto.setState(event.getState());
        eventDto.setCreatedAt(event.getCreatedAt());
        eventDto.setCustomerDto(new CustomerMapper().entityToDto(event.getCustomer()));
        eventDto.setUserDto(new UserMapper().entityToDto(event.getUser()));

        return eventDto;
    }

    public Event dtoToEntity(EventDto eventDto) {
        if(eventDto == null )
            return null;

        Event event = new Event();
        event.setId(eventDto.getId());
        event.setInitialDate(eventDto.getInitialDate());
        event.setEndDate(eventDto.getEndDate());
        event.setPayment(eventDto.getPayment());
        event.setObservation(eventDto.getObservation());
        event.setResolved(eventDto.getResolved());
        event.setState(eventDto.getState());
        event.setCreatedAt(eventDto.getCreatedAt());
        event.setCustomer(new CustomerMapper().dtoToEntity(eventDto.getCustomerDto()));
        event.setUser(new UserMapper().dtoToEntity(eventDto.getUserDto()));

        return event;
    }

}
