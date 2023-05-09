package com.devmf.chairSystem.controller;

import com.devmf.chairSystem.dto.Message;
import com.devmf.chairSystem.dto.MoneyDto;
import com.devmf.chairSystem.service.implementation.MoneyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/money")
@AllArgsConstructor
public class MoneyController {

    private final MoneyService moneyService;

    @GetMapping("")
    public ResponseEntity<List<MoneyDto>> moneyList() {
        return new ResponseEntity<>(
                moneyService.getAllMoneys(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMoney(@PathVariable("id") long id) {
        MoneyDto result = moneyService.getMoneyById(id);
        return result == null ?
                new ResponseEntity<>(new Message("Not found"), HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Message> saveMoney(@Valid @RequestBody MoneyDto moneyDto) {
        moneyService.saveMoney(moneyDto);
        return new ResponseEntity<>(new Message("Created money"), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMoney(@PathVariable("id") long id, @RequestBody MoneyDto moneyDto) {
        MoneyDto result = moneyService.getMoneyById(id);
        if(result == null)
            return new ResponseEntity<>(new Message("Not found"), HttpStatus.NOT_FOUND);

        result.setShortName(moneyDto.getShortName());
        result.setName(moneyDto.getName());
        moneyService.updateMoney(result);

        return new ResponseEntity<>(new Message("Updated money"), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMoney(@PathVariable("id") long id) {
        MoneyDto result = moneyService.getMoneyById(id);
        if(result == null)
            return new ResponseEntity<>(new Message("Not found"), HttpStatus.NOT_FOUND);

        moneyService.deleteMoney(result);

        return new ResponseEntity<>(new Message("Deleted money"), HttpStatus.OK);
    }

}
