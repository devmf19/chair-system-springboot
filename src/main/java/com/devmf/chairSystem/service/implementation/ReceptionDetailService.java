package com.devmf.chairSystem.service.implementation;

import com.devmf.chairSystem.dto.EventDetailDto;
import com.devmf.chairSystem.dto.ReceptionDetailDto;
import com.devmf.chairSystem.repository.ReceptionDetailRepository;
import com.devmf.chairSystem.service.interfaces.IReceptionDetailService;
import com.devmf.chairSystem.util.mapper.EventDetailMapper;
import com.devmf.chairSystem.util.mapper.ReceptionDetailMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReceptionDetailService implements IReceptionDetailService {
    private final ReceptionDetailRepository receptionDetailRepository;
    private final ReceptionDetailMapper receptionDetailMapper;
    private final EventDetailMapper eventDetailMapper;

    @Override
    public ReceptionDetailDto getReceptionDetailByEventDetail(EventDetailDto eventDetailDto) {
        return receptionDetailRepository.findByEventDetail(eventDetailMapper.dtoToEntity(eventDetailDto))
                .map(receptionDetailMapper::entityToDto)
                .orElse(null);
    }

    @Override
    public ReceptionDetailDto getReceptionDetailById(long id) {
        return receptionDetailRepository.findById(id)
                .map(receptionDetailMapper::entityToDto)
                .orElse(null);
    }

    @Override
    public void saveReceptionDetail(ReceptionDetailDto receptionDetailDto) {
        receptionDetailRepository.save(
                receptionDetailMapper.dtoToEntity(receptionDetailDto)
        );
    }

    @Override
    public void updateReceptionDetail(ReceptionDetailDto receptionDetailDto) {
        receptionDetailRepository.save(
                receptionDetailMapper.dtoToEntity(receptionDetailDto)
        );
    }

    @Override
    public void deleteReceptionDetail(ReceptionDetailDto receptionDetailDto) {
        receptionDetailRepository.delete(
                receptionDetailMapper.dtoToEntity(receptionDetailDto)
        );
    }
}
