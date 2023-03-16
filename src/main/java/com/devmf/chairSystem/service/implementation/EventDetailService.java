package com.devmf.chairSystem.service.implementation;

import com.devmf.chairSystem.dto.EventDetailDto;
import com.devmf.chairSystem.repository.EventDetailRepository;
import com.devmf.chairSystem.service.interfaces.IEventDetailService;
import com.devmf.chairSystem.service.mapping.EventDetailMap;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventDetailService implements IEventDetailService {

    @Autowired
    private EventDetailRepository eventDetailRepository;

    private final EventDetailMap eventDetailMap = new EventDetailMap();

    @Override
    public List<EventDetailDto> getEventDetails() {
        return eventDetailRepository.findAll()
                .stream()
                .map(eventDetailMap::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EventDetailDto> getEventDetailById(long id) {
        return Optional.of(
                eventDetailMap.entityToDto(
                        eventDetailRepository.findById(id).get()
                )
        );
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
