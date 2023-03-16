package com.devmf.chairSystem.service.implementation;

import com.devmf.chairSystem.dto.ReceptionDto;
import com.devmf.chairSystem.repository.ReceptionRepository;
import com.devmf.chairSystem.service.interfaces.IReceptionService;
import com.devmf.chairSystem.service.mapping.ReceptionMap;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReceptionService implements IReceptionService {

    @Autowired
    private ReceptionRepository receptionRepository;

    private ReceptionMap receptionMap = new ReceptionMap();


    @Override
    public List<ReceptionDto> getReceptions() {
        return receptionRepository.findAll()
                .stream()
                .map(receptionMap::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ReceptionDto> getReceptionById(long id) {
        return Optional.of(
                receptionMap.entityToDto(
                        receptionRepository.findById(id).get()
                )
        );
    }

    @Override
    public void saveReception(ReceptionDto receptionDto) {
        receptionRepository.save(
                receptionMap.dtoToEntity(receptionDto)
        );
    }

    @Override
    public void updateReception(ReceptionDto receptionDto) {
        receptionRepository.save(
                receptionMap.dtoToEntity(receptionDto)
        );
    }

    @Override
    public void deleteReception(ReceptionDto receptionDto) {
        receptionRepository.delete(
                receptionMap.dtoToEntity(receptionDto)
        );
    }
}
