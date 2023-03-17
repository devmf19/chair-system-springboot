package com.devmf.chairSystem.controller;

import com.devmf.chairSystem.dto.EventDetailDto;
import com.devmf.chairSystem.dto.EventDto;
import com.devmf.chairSystem.dto.Message;
import com.devmf.chairSystem.dto.ProductDto;
import com.devmf.chairSystem.service.implementation.EventDetailService;
import com.devmf.chairSystem.service.implementation.EventService;
import com.devmf.chairSystem.service.implementation.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/eventDetails")
@AllArgsConstructor
public class EventDetailController {

    private final EventDetailService eventDetailService;
    private final EventService eventService;
    private final ProductService productService;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(
                eventDetailService.getAllEventDetails(),
                HttpStatus.OK
        );
    }

    @GetMapping("/event/{eventId}")
    public ResponseEntity<?> getByEvent(@PathVariable("eventId") long eventId) {
        EventDto event = eventService.getEventById(eventId);
        if(event == null) {
            return new ResponseEntity<>(new Message("Not found event"), HttpStatus.NOT_FOUND);
        }

        List<EventDetailDto> eventDetails = eventDetailService.findEventDetailByEvent(event);

        HashMap<String, Object> response = new HashMap<>();
        response.put("Event", event);
        response.put("Products", eventDetails);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> saveDetail(@RequestBody EventDetailDto eventDetailDto) {
        EventDto event = eventService.getEventById(eventDetailDto.getEventDto().getId());
        if(event == null) {
            return new ResponseEntity<>(new Message("Not found event"), HttpStatus.NOT_FOUND);
        }

        ProductDto product = productService.getProductById(eventDetailDto.getProductDto().getId());
        if(product == null) {
            return new ResponseEntity<>(new Message("Not found product"), HttpStatus.NOT_FOUND);
        }

        eventDetailDto.setEventDto(event);
        eventDetailDto.setProductDto(product);

        eventDetailService.saveEventDetail(eventDetailDto);
        return new ResponseEntity<>(new Message("Saved event detail"), HttpStatus.CREATED);
    }

    @PutMapping("/event/{eventId}/detail/{detailId}")
    public ResponseEntity<?> updateDetail(@PathVariable("eventId") long eventId, @PathVariable("detailId") long detailId, @RequestBody EventDetailDto eventDetailDto) {
        EventDto event = eventService.getEventById(eventId);
        if(event == null) {
            return new ResponseEntity<>(new Message("Not found event"), HttpStatus.NOT_FOUND);
        }

        List<EventDetailDto> eventDetails = findDetailInEvent(event, detailId);

        if(eventDetails.isEmpty()) {
            return new ResponseEntity<>(new Message("Not found detail in event details"), HttpStatus.NOT_FOUND);
        }

        EventDetailDto result = eventDetails.get(0);
        result.setAmount(eventDetailDto.getAmount());
        result.setPrice(eventDetailDto.getPrice());
        result.setEventDto(event);

        eventDetailService.updateEventDetail(result);
        return new ResponseEntity<>(new Message("Updated event detail"), HttpStatus.OK);
    }

    @DeleteMapping("/event/{eventId}/detail/{detailId}")
    public ResponseEntity<?> deleteDetail(@PathVariable("eventId") long eventId, @PathVariable("detailId") long detailId) {
        EventDto event = eventService.getEventById(eventId);
        if(event == null) {
            return new ResponseEntity<>(new Message("Not found event"), HttpStatus.NOT_FOUND);
        }

        List<EventDetailDto> eventDetails = findDetailInEvent(event, detailId);

        if(eventDetails.isEmpty()) {
            return new ResponseEntity<>(new Message("Not found detail in event details"), HttpStatus.NOT_FOUND);
        }

        eventDetailService.deleteEventDetail(eventDetails.get(0));
        return new ResponseEntity<>(new Message("Deleted detail"), HttpStatus.OK);
    }

    private List<EventDetailDto> findDetailInEvent(EventDto event, long detailId) {
        return eventDetailService
                .findEventDetailByEvent(event)
                .stream()
                .filter(e -> e.getId() == detailId)
                .collect(Collectors.toList());
    }
}
