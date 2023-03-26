package com.devmf.chairSystem.service.interfaces;

import com.devmf.chairSystem.dto.EventDetailDto;
import com.devmf.chairSystem.dto.ReceptionDetailDto;
import com.devmf.chairSystem.dto.ReceptionDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IReceptionDetail {
    List<ReceptionDetailDto> getAllReceptionDetail();

    List<ReceptionDetailDto> getAllReceptionDetailByReception(ReceptionDto receptionDto);

    ReceptionDetailDto getByReceptionDetailByEventDetail(EventDetailDto eventDetailDto);

    void saveReceptionDetail(ReceptionDetailDto receptionDetailDto);

    void updateReceptionDetail(ReceptionDetailDto receptionDetailDto);

    void deleteReceptionDetail(ReceptionDetailDto receptionDetailDto);
}
