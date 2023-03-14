package com.devmf.chairSystem.Service.impl;

import com.devmf.chairSystem.Service.interfaces.ISettingService;
import com.devmf.chairSystem.model.Setting;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class SettingService implements ISettingService {
    @Override
    public Optional<Setting> getSettingById(long id) {
        return Optional.empty();
    }

    @Override
    public void updateSetting(Setting setting) {

    }
}
