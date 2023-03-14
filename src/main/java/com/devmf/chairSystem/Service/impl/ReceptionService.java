package com.devmf.chairSystem.Service.impl;

import com.devmf.chairSystem.Service.interfaces.IReceptionService;
import com.devmf.chairSystem.model.Reception;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReceptionService implements IReceptionService {
    @Override
    public List<Reception> getReceptions() {
        return null;
    }

    @Override
    public Optional<Reception> getReceptionById(long id) {
        return Optional.empty();
    }

    @Override
    public void saveReception(Reception reception) {

    }

    @Override
    public void updateReception(Reception reception) {

    }

    @Override
    public void deleteReception(Reception reception) {

    }
}
