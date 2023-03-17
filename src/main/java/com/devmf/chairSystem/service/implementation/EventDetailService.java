package com.devmf.chairSystem.service.implementation;

import com.devmf.chairSystem.dto.EventDetailDto;
import com.devmf.chairSystem.dto.EventDto;
import com.devmf.chairSystem.repository.EventDetailRepository;
import com.devmf.chairSystem.service.interfaces.IEventDetailService;
import com.devmf.chairSystem.service.mapping.EventDetailMap;
import com.devmf.chairSystem.service.mapping.EventMap;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EventDetailService implements IEventDetailService {

    private EventDetailRepository eventDetailRepository;

    private final EventDetailMap eventDetailMap;

    private final EventMap eventMap;

    @Override
    public List<EventDetailDto> getAllEventDetails() {
        return eventDetailRepository.findAll()
                .stream()
                .map(eventDetailMap::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public EventDetailDto getEventDetailById(long id) {
        return eventDetailRepository.findById(id)
                .map(eventDetailMap::entityToDto)
                .orElse(null);
    }

    @Override
    public List<EventDetailDto> findEventDetailByEvent(EventDto eventDto) {
        return eventDetailRepository.findEventDetailByEvent(eventMap.dtoToEntity(eventDto))
                .stream()
                .map(eventDetailMap::entityToDto)
                .peek(eventDetailDto -> eventDetailDto.setEventDto(null))
                .collect(Collectors.toList());
    }

    @Override
    public void saveEventDetail(EventDetailDto eventDetailDto) {
        eventDetailRepository.save(
                eventDetailMap.dtoToEntity(eventDetailDto)
        );
    }

    @Override
    public void updateEventDetail(EventDetailDto eventDetailDto) {
        eventDetailRepository.save(
                eventDetailMap.dtoToEntity(eventDetailDto)
        );
    }

    @Override
    public void deleteEventDetail(EventDetailDto eventDetailDto) {
        eventDetailRepository.delete(
                eventDetailMap.dtoToEntity(eventDetailDto)
        );
    }
}
