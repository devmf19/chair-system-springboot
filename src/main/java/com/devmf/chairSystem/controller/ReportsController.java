package com.devmf.chairSystem.controller;

import com.devmf.chairSystem.dto.DateRequest;
import com.devmf.chairSystem.dto.EventDto;
import com.devmf.chairSystem.dto.Message;
import com.devmf.chairSystem.service.implementation.EventDetailService;
import com.devmf.chairSystem.service.implementation.EventService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/report")
@AllArgsConstructor
public class ReportsController {
    private final EventService eventService;
    private final EventDetailService eventDetailService;

    @PostMapping("/events")
    public ResponseEntity<?> getEventsBetween(@RequestBody DateRequest dateRequest) {
        return new ResponseEntity<>(eventService.getEventsBetween(
                Date.valueOf( dateRequest.getInitialDate()),
                Date.valueOf(dateRequest.getEndDate())
        ), HttpStatus.OK);
    }

    @PostMapping("/earnings")
    public ResponseEntity<?> getEarningsBetween(@RequestBody DateRequest dateRequest) {
        List<EventDto> events = eventService.getEventsBetween(
                Date.valueOf( dateRequest.getInitialDate()),
                Date.valueOf(dateRequest.getEndDate())
        );
        double earnings = events.stream()
                .filter(event -> event.getResolved() == 1)
                .map(event -> eventDetailService.findEventDetailByEvent(event)
                                .stream()
                                .map(ed -> ed.getAmount() * ed.getPrice())
                                .toList()
                                .stream()
                                .mapToDouble(Double::doubleValue)
                                .sum()
                )
                .toList()
                .stream()
                .mapToDouble(Double::doubleValue)
                .sum();

        return new ResponseEntity<>(new Message("Earnings: "+earnings), HttpStatus.OK);
    }
}
