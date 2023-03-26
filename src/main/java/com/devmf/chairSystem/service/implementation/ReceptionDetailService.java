package com.devmf.chairSystem.service.implementation;

import com.devmf.chairSystem.dto.EventDetailDto;
import com.devmf.chairSystem.dto.ReceptionDetailDto;
import com.devmf.chairSystem.dto.ReceptionDto;
import com.devmf.chairSystem.repository.ReceptionDetailRepository;
import com.devmf.chairSystem.service.interfaces.IReceptionDetail;
import com.devmf.chairSystem.util.mapper.EventDetailMapper;
import com.devmf.chairSystem.util.mapper.ReceptionDetailMapper;
import com.devmf.chairSystem.util.mapper.ReceptionMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReceptionDetailService implements IReceptionDetail {
    private final ReceptionDetailRepository receptionDetailRepository;

    private final ReceptionDetailMapper receptionDetailMapper;

    private final ReceptionMapper receptionMapper;

    private final EventDetailMapper eventDetailMapper;

    @Override
    public List<ReceptionDetailDto> getAllReceptionDetail() {
        return receptionDetailRepository.findAll()
                .stream()
                .map(receptionDetailMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReceptionDetailDto> getAllReceptionDetailByReception(ReceptionDto receptionDto) {
        return receptionDetailRepository.findAllByReception(receptionMapper.dtoToEntity(receptionDto))
                .stream()
                .map(receptionDetailMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ReceptionDetailDto getByReceptionDetailByEventDetail(EventDetailDto eventDetailDto) {
        return receptionDetailRepository.findByEventDetail(eventDetailMapper.dtoToEntity(eventDetailDto))
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
