package com.devmf.chairSystem.util.mapper;

import com.devmf.chairSystem.dto.ReceptionDto;
import com.devmf.chairSystem.model.Reception;
import org.springframework.stereotype.Component;

@Component
public class ReceptionMapper {
    public ReceptionDto entityToDto(Reception reception) {
        if(reception == null )
            return null;

        ReceptionDto receptionDto =  new ReceptionDto();
        receptionDto.setId(reception.getId());
        receptionDto.setObservations(reception.getObservations());

        return receptionDto;
    }

    public Reception dtoToEntity(ReceptionDto receptionDto) {
        if(receptionDto == null )
            return null;

        Reception reception =  new Reception();
        reception.setId(receptionDto.getId());
        reception.setObservations(receptionDto.getObservations());

        return reception;
    }
}
