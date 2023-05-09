package com.devmf.chairSystem.util.mapper;

import com.devmf.chairSystem.dto.SettingDto;
import com.devmf.chairSystem.model.Setting;
import org.springframework.stereotype.Component;

@Component
public class SettingMapper {
    public SettingDto entityToDto(Setting setting) {
        return setting == null
            ? null
            : new SettingDto(
                setting.getId(),
                setting.getNit(),
                setting.getName(),
                setting.getPhone(),
                setting.getEmail(),
                setting.getAddress(),
                new MoneyMapper().entityToDto(setting.getMoney())
            );
    }

    public Setting dtoToEntity(SettingDto settingDto) {
        return settingDto == null
            ? null
            : new Setting(
                settingDto.getId(),
                settingDto.getNit(),
                settingDto.getName(),
                settingDto.getPhone(),
                settingDto.getEmail(),
                settingDto.getAddress(),
                new MoneyMapper().dtoToEntity(settingDto.getMoney())
            );
    }
}
