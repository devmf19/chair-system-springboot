package com.devmf.chairSystem.service.interfaces;

import com.devmf.chairSystem.dto.EventDetailDto;
import com.devmf.chairSystem.dto.ReceptionDetailDto;
import com.devmf.chairSystem.dto.ReceptionDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IReceptionDetailService {
    ReceptionDetailDto getReceptionDetailByEventDetail(EventDetailDto eventDetailDto);

    ReceptionDetailDto getReceptionDetailById(long id);

    void saveReceptionDetail(ReceptionDetailDto receptionDetailDto);

    void updateReceptionDetail(ReceptionDetailDto receptionDetailDto);

    void deleteReceptionDetail(ReceptionDetailDto receptionDetailDto);
}
