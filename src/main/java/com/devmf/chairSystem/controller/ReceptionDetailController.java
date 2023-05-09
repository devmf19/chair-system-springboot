package com.devmf.chairSystem.controller;

import com.devmf.chairSystem.dto.EventDetailDto;
import com.devmf.chairSystem.dto.Message;
import com.devmf.chairSystem.dto.ReceptionDetailDto;
import com.devmf.chairSystem.dto.ReceptionDto;
import com.devmf.chairSystem.service.implementation.EventDetailService;
import com.devmf.chairSystem.service.implementation.ReceptionDetailService;
import com.devmf.chairSystem.service.implementation.ReceptionService;
import com.devmf.chairSystem.util.mapper.ReceptionMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/receptions/detail")
@AllArgsConstructor
public class ReceptionDetailController {
    private final ReceptionDetailService receptionDetailService;
    private final ReceptionService receptionService;
    private final EventDetailService eventDetailService;
    private final ReceptionMapper receptionMapper;

    @PostMapping("")
    public ResponseEntity<?> saveReceptionDetail(@RequestBody ReceptionDetailDto receptionDetailDto){
        if(receptionDetailDto.getAmount() < 0)
            return new ResponseEntity<>(new Message("The reception amount can´t be less than 0"), HttpStatus.BAD_REQUEST);

        ReceptionDto reception = receptionMapper.entityToDto(receptionService.getReceptionById(receptionDetailDto.getReceptionId()));
        if(receptionService.validateReception(reception))
            return new ResponseEntity<>(new Message("Not found reception"), HttpStatus.NOT_FOUND);

        EventDetailDto eventDetail = eventDetailService.getEventDetailById(receptionDetailDto.getEventDetail().getId());
        if (eventDetail == null)
            return new ResponseEntity<>(new Message("Not found detail"), HttpStatus.NOT_FOUND);

        receptionDetailDto.setEventDetail(eventDetail);
        receptionDetailService.saveReceptionDetail(receptionDetailDto);

        return new ResponseEntity<>(new Message("Saved reception detail"), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteReceptionDetail(@PathVariable("id") long id) {
        ReceptionDetailDto receptionDetailDto = receptionDetailService.getReceptionDetailById(id);
        if(receptionDetailDto == null)
            return new ResponseEntity<>(new Message("Not found reception detail"), HttpStatus.NOT_FOUND);

        receptionDetailService.deleteReceptionDetail(receptionDetailDto);

        return new ResponseEntity<>(new Message("Deleted detail"), HttpStatus.OK);
    }

}
