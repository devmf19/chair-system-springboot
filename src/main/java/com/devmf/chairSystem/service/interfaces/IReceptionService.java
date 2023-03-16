package com.devmf.chairSystem.service.interfaces;

import com.devmf.chairSystem.dto.ReceptionDto;
import com.devmf.chairSystem.model.Reception;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface IReceptionService {
    public List<ReceptionDto> getReceptions();

    public Optional<ReceptionDto> getReceptionById(long id);

    public void saveReception(ReceptionDto receptionDto);

    public void updateReception(ReceptionDto receptionDto);

    public void deleteReception(ReceptionDto receptionDto);
}
