package com.devmf.chairSystem.service.mapping;

import com.devmf.chairSystem.dto.ReceptionDto;
import com.devmf.chairSystem.model.Reception;
import org.springframework.stereotype.Component;

@Component
public class ReceptionMap {
    public ReceptionDto entityToDto(Reception reception) {
        if(reception == null ) {
            return null;
        }
        ReceptionDto receptionDto =  new ReceptionDto();

        receptionDto.setId(reception.getId());
        receptionDto.setObservations(reception.getObservations());
        receptionDto.setEventDto(new EventMap().entityToDto(reception.getEvent()));
        receptionDto.setUserDto(new UserMap().entityToDto(reception.getUser()));

        return receptionDto;
    }

    public Reception dtoToEntity(ReceptionDto receptionDto) {
        if(receptionDto == null ) {
            return null;
        }
        Reception reception =  new Reception();

        reception.setId(receptionDto.getId());
        reception.setObservations(receptionDto.getObservations());
        reception.setEvent(new EventMap().dtoToEntity(receptionDto.getEventDto()));
        reception.setUser(new UserMap().dtoToEntity(receptionDto.getUserDto()));

        return reception;
    }
}
