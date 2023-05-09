package com.devmf.chairSystem.controller;

import com.devmf.chairSystem.dto.Message;
import com.devmf.chairSystem.dto.ReceptionDto;
import com.devmf.chairSystem.service.implementation.ReceptionService;
import com.devmf.chairSystem.util.mapper.ReceptionMapper;
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
    private ReceptionMapper receptionMapper;

    @GetMapping("/{id}")
    public ResponseEntity<?> getReception(@PathVariable("id") long id) {
        ReceptionDto receptionDto = receptionMapper.entityToDto(receptionService.getReceptionById(id));
        return receptionDto == null ?
                new ResponseEntity<>(new Message("Not found reception"), HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(receptionDto, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> saveReception(@RequestBody ReceptionDto receptionDto) {
        receptionService.saveReception(receptionDto);
        return new ResponseEntity<>(new Message("Reception done"), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateReception(@PathVariable("id") long id, @RequestBody ReceptionDto receptionDto) {
        ReceptionDto result = receptionMapper.entityToDto(receptionService.getReceptionById(id));
        if(result == null)
            return new ResponseEntity<>(new Message("Not found reception"), HttpStatus.NOT_FOUND);

        result.setObservations(receptionDto.getObservations());
        receptionService.saveReception(result);

        return new ResponseEntity<>(new Message("Updated reception"), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteReception(@PathVariable("id") long id) {
        ReceptionDto result = receptionMapper.entityToDto(receptionService.getReceptionById(id));
        if(result == null)
            return new ResponseEntity<>(new Message("Not found reception"), HttpStatus.NOT_FOUND);

        receptionService.deleteReception(result);

        return new ResponseEntity<>(new Message("Deleted reception"), HttpStatus.OK);
    }
}
