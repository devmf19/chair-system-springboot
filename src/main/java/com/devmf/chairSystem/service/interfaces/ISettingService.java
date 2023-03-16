package com.devmf.chairSystem.service.interfaces;

import com.devmf.chairSystem.dto.SettingDto;
import org.springframework.stereotype.Component;


@Component
public interface ISettingService {

    SettingDto getSetting();

    void updateSetting(SettingDto settingDto);
}
