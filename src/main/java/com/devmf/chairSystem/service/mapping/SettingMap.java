package com.devmf.chairSystem.service.mapping;

import com.devmf.chairSystem.dto.SettingDto;
import com.devmf.chairSystem.model.Setting;
import org.springframework.stereotype.Component;

@Component
public class SettingMap {

    public SettingDto entityToDto(Setting setting) {
        if(setting == null ) {
            return null;
        }
        SettingDto settingDto = new SettingDto();

        settingDto.setId(setting.getId());
        settingDto.setNit(setting.getNit());
        settingDto.setName(setting.getName());
        settingDto.setEmail(setting.getEmail());
        settingDto.setAddress(setting.getAdreess());
        settingDto.setPhone(setting.getPhone());
        settingDto.setMoneyDto(new MoneyMap().entityToDto(setting.getMoney()));

        return settingDto;
    }

    public Setting dtoToEntity(SettingDto settingDto) {
        if(settingDto == null ) {
            return null;
        }
        Setting setting = new Setting();

        setting.setId(settingDto.getId());
        setting.setNit(settingDto.getNit());
        setting.setName(settingDto.getName());
        setting.setEmail(settingDto.getEmail());
        setting.setAdreess(settingDto.getAddress());
        setting.setPhone(settingDto.getPhone());
        setting.setMoney(new MoneyMap().dtoToEntity(settingDto.getMoneyDto()));

        return setting;
    }
}
