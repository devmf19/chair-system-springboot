package com.devmf.chairSystem.controller;

import com.devmf.chairSystem.dto.EventDto;
import com.devmf.chairSystem.dto.Message;
import com.devmf.chairSystem.dto.ReceptionDto;
import com.devmf.chairSystem.security.dto.UserDto;
import com.devmf.chairSystem.service.implementation.EventService;
import com.devmf.chairSystem.service.implementation.ReceptionService;
import com.devmf.chairSystem.security.service.implementation.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/receptions")
@AllArgsConstructor
public class ReceptionController {

    private ReceptionService receptionService;
    private EventService eventService;
    private UserService userService;

    @GetMapping("")
    public ResponseEntity<?> receptionsList() {
        return new ResponseEntity<>(
                receptionService.getReceptions(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getReception(@PathVariable("id") long id) {
        ReceptionDto receptionDto = receptionService.getReceptionById(id);
        return receptionDto == null ?
                new ResponseEntity<>(new Message("Not found reception"), HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(receptionDto, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> saveReception(@RequestBody ReceptionDto receptionDto) {
        EventDto eventDto = eventService.getEventById(receptionDto.getEventDto().getId());
        if(eventDto == null) {
            return new ResponseEntity<>(new Message("Not found event"), HttpStatus.NOT_FOUND);
        }

        UserDto userDto = userService.getUserById(receptionDto.getUserDto().getId());
        if(userDto == null) {
            return new ResponseEntity<>(new Message("Not found user"), HttpStatus.NOT_FOUND);
        }

        eventDto.setState("RECIBIDO");
        eventService.updateEvent(eventDto);

        receptionDto.setEventDto(eventDto);
        receptionDto.setUserDto(userDto);

        receptionService.saveReception(receptionDto);
        return new ResponseEntity<>(new Message("Reception done"), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateReception(@PathVariable("id") long id, @RequestBody ReceptionDto receptionDto) {
        ReceptionDto result = receptionService.getReceptionById(id);
        if(result == null) {
            return new ResponseEntity<>(new Message("Not found reception"), HttpStatus.NOT_FOUND);
        }

        result.setObservations(receptionDto.getObservations());

        receptionService.saveReception(result);
        return new ResponseEntity<>(new Message("Updated reception"), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteReception(@PathVariable("id") long id) {
        ReceptionDto result = receptionService.getReceptionById(id);
        if(result == null) {
            return new ResponseEntity<>(new Message("Not found reception"), HttpStatus.NOT_FOUND);
        }

        result.getEventDto().setState("ENTREGADO");
        eventService.updateEvent(result.getEventDto());

        receptionService.deleteReception(result);
        return new ResponseEntity<>(new Message("Deleted reception"), HttpStatus.OK);
    }
}
