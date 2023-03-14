package com.devmf.chairSystem.Service.interfaces;

import com.devmf.chairSystem.model.Setting;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public interface ISettingService {

    public Optional<Setting> getSettingById(long id);

    public void updateSetting(Setting setting);
}
