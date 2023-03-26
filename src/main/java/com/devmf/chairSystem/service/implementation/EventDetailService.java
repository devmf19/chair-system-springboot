package com.devmf.chairSystem.service.implementation;

import com.devmf.chairSystem.dto.EventDetailDto;
import com.devmf.chairSystem.dto.EventDto;
import com.devmf.chairSystem.repository.EventDetailRepository;
import com.devmf.chairSystem.service.interfaces.IEventDetailService;
import com.devmf.chairSystem.util.mapper.EventDetailMapper;
import com.devmf.chairSystem.util.mapper.EventMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EventDetailService implements IEventDetailService {

    private EventDetailRepository eventDetailRepository;
    private final EventDetailMapper eventDetailMapper;
    private final EventMapper eventMapper;

    @Override
    public List<EventDetailDto> getAllEventDetails() {
        return eventDetailRepository.findAll()
                .stream()
                .map(eventDetailMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public EventDetailDto getEventDetailById(long id) {
        return eventDetailRepository.findById(id)
                .map(eventDetailMapper::entityToDto)
                .orElse(null);
    }

    @Override
    public List<EventDetailDto> findEventDetailByEvent(EventDto eventDto) {
        return eventDetailRepository.findAllByEvent(eventMapper.dtoToEntity(eventDto))
                .stream()
                .map(eventDetailMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void saveEventDetail(EventDetailDto eventDetailDto) {
        eventDetailRepository.save(
                eventDetailMapper.dtoToEntity(eventDetailDto)
        );
    }

    @Override
    public void updateEventDetail(EventDetailDto eventDetailDto) {
        eventDetailRepository.save(
                eventDetailMapper.dtoToEntity(eventDetailDto)
        );
    }

    @Override
    public void deleteEventDetail(EventDetailDto eventDetailDto) {
        eventDetailRepository.delete(
                eventDetailMapper.dtoToEntity(eventDetailDto)
        );
    }
}
