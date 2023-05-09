package com.devmf.chairSystem.service.interfaces;

import com.devmf.chairSystem.dto.ReceptionDto;
import com.devmf.chairSystem.model.Reception;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IReceptionService {
    Reception getReceptionById(long id);

    void saveReception(ReceptionDto receptionDto);

    void updateReception(ReceptionDto receptionDto);

    void deleteReception(ReceptionDto receptionDto);

    boolean validateReception(ReceptionDto receptionDto);
}
