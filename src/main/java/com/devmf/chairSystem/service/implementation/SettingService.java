package com.devmf.chairSystem.service.implementation;

import com.devmf.chairSystem.dto.SettingDto;
import com.devmf.chairSystem.repository.SettingRepository;
import com.devmf.chairSystem.service.interfaces.ISettingService;
import com.devmf.chairSystem.service.mapping.SettingMap;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class SettingService implements ISettingService {

    private SettingRepository settingRepository;

    private SettingMap settingMap;

    @Override
    public SettingDto getSetting() {
        return settingMap.entityToDto(
                settingRepository.findAll().get(0)
        );
    }

    @Override
    public void updateSetting(SettingDto settingDto) {
        settingRepository.save(
                settingMap.dtoToEntity(settingDto)
        );
    }
}
