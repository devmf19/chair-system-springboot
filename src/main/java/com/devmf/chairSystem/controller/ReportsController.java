package com.devmf.chairSystem.controller;

import com.devmf.chairSystem.dto.DateRequest;
import com.devmf.chairSystem.dto.EventDto;
import com.devmf.chairSystem.dto.Message;
import com.devmf.chairSystem.service.implementation.EventService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/report")
@AllArgsConstructor
public class ReportsController {
    private final EventService eventService;

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
                .filter(event -> event.getState().equalsIgnoreCase("RECIBIDO"))
                .map(event -> event.getEventDetails()
                                .stream()
                                .map(ed -> ed.getAmount() * ed.getPrice())
                                .collect(Collectors.toList())
                                .stream()
                                .mapToDouble(Double::doubleValue)
                                .sum()
                )
                .collect(Collectors.toList())
                .stream()
                .mapToDouble(Double::doubleValue)
                .sum();

        return new ResponseEntity<>(new Message("Earnings: "+earnings), HttpStatus.OK);
    }
}
