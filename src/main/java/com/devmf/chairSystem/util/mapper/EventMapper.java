package com.devmf.chairSystem.util.mapper;

import com.devmf.chairSystem.dto.EventDetailDto;
import com.devmf.chairSystem.dto.EventDto;
import com.devmf.chairSystem.model.Event;
import com.devmf.chairSystem.model.EventDetail;
import com.devmf.chairSystem.security.service.implementation.UserService;
import com.devmf.chairSystem.service.implementation.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventMapper {
    @Autowired
    private UserService userService;
    @Autowired
    private CustomerService customerService;
    private final UserMapper userMapper = new UserMapper();
    private final CustomerMapper customerMapper = new CustomerMapper();
    private final EventDetailMapper eventDetailMapper = new EventDetailMapper();

    public EventDto entityToDto(Event event) {
        return event == null
            ? null
            : new EventDto(
                event.getId(),
                event.getName(),
                event.getInitialDate(),
                event.getEndDate(),
                event.getState(),
                event.getObservation(),
                event.getCreatedAt(),
                userMapper.entityToDto(event.getUser()),
                customerMapper.entityToDto(event.getCustomer()),
                entityToDtoList(event.getEventDetails())
            );
    }

    public Event dtoToEntity(EventDto eventDto) {
        return eventDto == null
                ? null
                : new Event(
                eventDto.getId(),
                eventDto.getName(),
                eventDto.getInitialDate(),
                eventDto.getEndDate(),
                eventDto.getState(),
                eventDto.getObservation(),
                userService.getByDui(eventDto.getUser().getDui()),
                customerService.getCustomerByDui(eventDto.getCustomer().getDui())
        );
    }

    private List<EventDetailDto> entityToDtoList(List<EventDetail> eventDetails) {
        return eventDetails
                .stream()
                .map(eventDetailMapper::entityToDto)
                .collect(Collectors.toList());
    }

}
