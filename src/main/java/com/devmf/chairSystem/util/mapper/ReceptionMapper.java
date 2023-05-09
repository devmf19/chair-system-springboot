package com.devmf.chairSystem.util.mapper;

import com.devmf.chairSystem.dto.ReceptionDetailDto;
import com.devmf.chairSystem.dto.ReceptionDto;
import com.devmf.chairSystem.model.Reception;
import com.devmf.chairSystem.model.ReceptionDetail;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReceptionMapper {
    private final ReceptionDetailMapper receptionDetailMapper = new ReceptionDetailMapper();

    public ReceptionDto entityToDto(Reception reception) {
        return reception == null
                ? null
                : new ReceptionDto(
                reception.getId(),
                reception.getObservations(),
                reception.getCreatedAt(),
                entityToDtoList(reception.getReceptionDetails())
        );
    }

    public Reception dtoToEntity(ReceptionDto receptionDto) {
        return receptionDto == null
                ? null
                : new Reception(
                receptionDto.getId(),
                receptionDto.getObservations()
        );
    }

    private List<ReceptionDetailDto> entityToDtoList(List<ReceptionDetail> receptionDetails) {
        return receptionDetails
                .stream()
                .map(receptionDetailMapper::entityToDto)
                .collect(Collectors.toList());
    }
}
