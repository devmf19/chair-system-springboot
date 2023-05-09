package com.devmf.chairSystem.controller;

import com.devmf.chairSystem.dto.EventDto;
import com.devmf.chairSystem.dto.Message;
import com.devmf.chairSystem.service.implementation.EventService;
import com.devmf.chairSystem.util.mapper.EventMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/events")
@AllArgsConstructor
public class EventController {
    private final EventService eventService;
    private EventMapper eventMapper;

    @GetMapping("")
    public ResponseEntity<?> eventsList() {
        return new ResponseEntity<>(
                eventService.getEvents(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEvent(@PathVariable("id") long id) {
        EventDto result = eventMapper.entityToDto(eventService.getEventById(id));
        if (eventService.validateEvent(result))
            return new ResponseEntity<>(new Message("Not found event"), HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PostMapping("")
    public ResponseEntity<?> saveEvent(@RequestBody EventDto eventDto) {
        eventService.saveEvent(eventDto);
        return new ResponseEntity<>(new Message("Created event"), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEvent(@PathVariable("id") long id, @RequestBody EventDto eventDto) {
        EventDto result = eventMapper.entityToDto(eventService.getEventById(id));
        if (eventService.validateEvent(result))
            return new ResponseEntity<>(new Message("Not found event"), HttpStatus.NOT_FOUND);

        eventDto.setId(result.getId());
        eventService.updateEvent(eventDto);

        return new ResponseEntity<>(new Message("Updated event"), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> updateEvent(@PathVariable("id") long id) {
        EventDto result = eventMapper.entityToDto(eventService.getEventById(id));
        if (eventService.validateEvent(result))
            return new ResponseEntity<>(new Message("Not found event"), HttpStatus.NOT_FOUND);

        result.setState("CANCELADO");
        eventService.updateEvent(result);
        return new ResponseEntity<>(new Message("Canceled event"), HttpStatus.OK);
    }
}
