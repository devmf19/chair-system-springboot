package com.devmf.chairSystem.util.mapper;

import com.devmf.chairSystem.dto.ReceptionDetailDto;
import com.devmf.chairSystem.model.ReceptionDetail;
import org.springframework.stereotype.Component;

@Component
public class ReceptionDetailMapper {

    public ReceptionDetailDto entityToDto(ReceptionDetail receptionDetail) {
        if(receptionDetail == null)
            return null;

        ReceptionDetailDto receptionDetailDto = new ReceptionDetailDto();
        receptionDetailDto.setId(receptionDetail.getId());
        receptionDetailDto.setAmount(receptionDetail.getAmount());
        receptionDetailDto.setEventDetailDto(new EventDetailMapper().entityToDto(receptionDetail.getEventDetail()));
        receptionDetailDto.setReceptionDto(new ReceptionMapper().entityToDto(receptionDetail.getReception()));

        return receptionDetailDto;
    }

    public ReceptionDetail dtoToEntity(ReceptionDetailDto receptionDetailDto) {
        if(receptionDetailDto == null)
            return null;

        ReceptionDetail receptionDetail = new ReceptionDetail();
        receptionDetail.setId(receptionDetailDto.getId());
        receptionDetail.setAmount(receptionDetailDto.getAmount());
        receptionDetail.setEventDetail(new EventDetailMapper().dtoToEntity(receptionDetailDto.getEventDetailDto()));
        receptionDetail.setReception(new ReceptionMapper().dtoToEntity(receptionDetailDto.getReceptionDto()));

        return receptionDetail;
    }
}
