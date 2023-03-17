package com.devmf.chairSystem.service.interfaces;

import com.devmf.chairSystem.dto.ReceptionDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IReceptionService {
    List<ReceptionDto> getReceptions();
    ReceptionDto getReceptionById(long id);

    void saveReception(ReceptionDto receptionDto);

    void updateReception(ReceptionDto receptionDto);

    void deleteReception(ReceptionDto receptionDto);
}
