package com.devmf.chairSystem.Service.interfaces;

import com.devmf.chairSystem.model.Reception;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface IReceptionService {
    public List<Reception> getReceptions();

    public Optional<Reception> getReceptionById(long id);

    public void saveReception(Reception reception);

    public void updateReception(Reception reception);

    public void deleteReception(Reception reception);
}
