package com.devmf.chairSystem.service.mapping;

import com.devmf.chairSystem.dto.EventDto;
import com.devmf.chairSystem.model.Event;
import org.springframework.stereotype.Component;

@Component
public class EventMap {
    public EventDto entityToDto(Event event) {
        EventDto eventDto = new EventDto();

        eventDto.setId(event.getId());
        eventDto.setDays(event.getDays());
        eventDto.setInitialDate(event.getInitialDate());
        eventDto.setEndDate(event.getEndDate());
        eventDto.setPayment(event.getPayment());
        eventDto.setObservation(event.getObservation());
        eventDto.setState(event.getState());
        eventDto.setCustomerDto(new CustomerMap().entityToDto(event.getCustomer()));
        eventDto.setUserDto(new UserMap().entityToDto(event.getUser()));

        return eventDto;
    }

    public Event dtoToEntity(EventDto eventDto) {
        Event event = new Event();

        event.setId(eventDto.getId());
        event.setDays(eventDto.getDays());
        event.setInitialDate(eventDto.getInitialDate());
        event.setEndDate(eventDto.getEndDate());
        event.setPayment(eventDto.getPayment());
        event.setObservation(eventDto.getObservation());
        event.setState(eventDto.getState());
        event.setCustomer(new CustomerMap().dtoToEntity(eventDto.getCustomerDto()));
        event.setUser(new UserMap().dtoToEntity(eventDto.getUserDto()));

        return event;
    }
}
