package com.devmf.chairSystem.controller;

import com.devmf.chairSystem.dto.Message;
import com.devmf.chairSystem.dto.MoneyDto;
import com.devmf.chairSystem.dto.SettingDto;
import com.devmf.chairSystem.service.implementation.MoneyService;
import com.devmf.chairSystem.service.implementation.SettingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/setting")
@AllArgsConstructor
public class SettingController {

    private final SettingService settingService;
    private final MoneyService moneyService;

    @GetMapping("")
    public ResponseEntity<?> getSetting(){
        return new ResponseEntity<>(
                settingService.getSetting(),
                HttpStatus.OK
        );
    }

    @PutMapping("")
    public ResponseEntity<?> updateSetting(@RequestBody SettingDto settingDto){
        MoneyDto moneyDto = moneyService.getMoneyById(settingDto.getMoneyDto().getId());
        if(moneyDto == null){
            return new ResponseEntity<>(new Message("Invalid money id"), HttpStatus.BAD_REQUEST);
        }

        settingDto.setMoneyDto(moneyDto);
        settingService.updateSetting(settingDto);

        return new ResponseEntity<>(new Message("Updated setting"), HttpStatus.OK);
    }
}
