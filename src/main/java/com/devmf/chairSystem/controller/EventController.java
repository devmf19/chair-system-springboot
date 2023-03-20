package com.devmf.chairSystem.controller;

import com.devmf.chairSystem.dto.EventDto;
import com.devmf.chairSystem.dto.Message;
import com.devmf.chairSystem.service.implementation.EventService;
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

    @GetMapping("")
    public ResponseEntity<?> eventsList() {
        return new ResponseEntity<>(
                eventService.getEvents(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEvent(@PathVariable("id") long id) {
        EventDto result = eventService.getEventById(id);
        return result == null ?
                new ResponseEntity<>(new Message("Not found event"), HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(result, HttpStatus.CREATED);

    }

    @PostMapping("")
    public ResponseEntity<?> saveEvent(@RequestBody EventDto eventDto) {
        eventDto.setState("RESERVADO");
        eventService.saveEvent(eventDto);
        return new ResponseEntity<>(new Message("Created event"), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEvent(@PathVariable("id") long id, @RequestBody EventDto eventDto) {
        EventDto result = eventService.getEventById(id);
        if (result == null) {
            return new ResponseEntity<>(new Message("Not found event"), HttpStatus.NOT_FOUND);
        }
        eventDto.setId(result.getId());
        eventService.updateEvent(eventDto);
        return new ResponseEntity<>(new Message("Updated event"), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> updateEvent(@PathVariable("id") long id) {
        EventDto result = eventService.getEventById(id);
        if (result == null) {
            return new ResponseEntity<>(new Message("Not found event"), HttpStatus.NOT_FOUND);
        }
        result.setState("CANCELADO");
        eventService.updateEvent(result);
        return new ResponseEntity<>(new Message("Canceled event"), HttpStatus.OK);
    }
}
