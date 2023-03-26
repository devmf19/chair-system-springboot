package com.devmf.chairSystem.service.implementation;

import com.devmf.chairSystem.dto.SettingDto;
import com.devmf.chairSystem.repository.SettingRepository;
import com.devmf.chairSystem.service.interfaces.ISettingService;
import com.devmf.chairSystem.util.mapper.SettingMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class SettingService implements ISettingService {

    private SettingRepository settingRepository;

    private SettingMapper settingMapper;

    @Override
    public SettingDto getSetting() {
        return settingMapper.entityToDto(
                settingRepository.findAll().get(0)
        );
    }

    @Override
    public void updateSetting(SettingDto settingDto) {
        settingRepository.save(
                settingMapper.dtoToEntity(settingDto)
        );
    }
}
