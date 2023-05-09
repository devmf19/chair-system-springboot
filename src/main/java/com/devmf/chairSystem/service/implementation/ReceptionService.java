package com.devmf.chairSystem.service.implementation;

import com.devmf.chairSystem.dto.ReceptionDto;
import com.devmf.chairSystem.model.Reception;
import com.devmf.chairSystem.repository.ReceptionRepository;
import com.devmf.chairSystem.service.interfaces.IReceptionService;
import com.devmf.chairSystem.util.mapper.ReceptionMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReceptionService implements IReceptionService {
    private ReceptionRepository receptionRepository;
    private ReceptionMapper receptionMapper;

    @Override
    public Reception getReceptionById(long id) {
        return receptionRepository.findById(id).orElse(null);
    }

    @Override
    public void saveReception(ReceptionDto receptionDto) {
        receptionRepository.save(
                receptionMapper.dtoToEntity(receptionDto)
        );
    }

    @Override
    public void updateReception(ReceptionDto receptionDto) {
        receptionRepository.save(
                receptionMapper.dtoToEntity(receptionDto)
        );
    }

    @Override
    public void deleteReception(ReceptionDto receptionDto) {
        receptionRepository.delete(
                receptionMapper.dtoToEntity(receptionDto)
        );
    }

    @Override
    public boolean validateReception(ReceptionDto receptionDto) {
        return receptionDto == null;
    }
}
