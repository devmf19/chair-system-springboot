package com.devmf.chairSystem.util.mapper;

import com.devmf.chairSystem.dto.ReceptionDetailDto;
import com.devmf.chairSystem.model.ReceptionDetail;
import com.devmf.chairSystem.service.implementation.ReceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReceptionDetailMapper {
    @Autowired
    private ReceptionService receptionService;
    private final EventDetailMapper eventDetailMapper = new EventDetailMapper();

    public ReceptionDetailDto entityToDto(ReceptionDetail receptionDetail) {
        return receptionDetail == null
                ? null
                : new ReceptionDetailDto(
                receptionDetail.getId(),
                receptionDetail.getAmount(),
                receptionDetail.getReception().getId(),
                eventDetailMapper.entityToDto(receptionDetail.getEventDetail())
        );
    }

    public ReceptionDetail dtoToEntity(ReceptionDetailDto receptionDetailDto) {
        return receptionDetailDto == null
                ? null
                : new ReceptionDetail(
                receptionDetailDto.getId(),
                receptionDetailDto.getAmount(),
                eventDetailMapper.dtoToEntity(receptionDetailDto.getEventDetail()),
                receptionService.getReceptionById(receptionDetailDto.getReceptionId())
        );
    }
}
