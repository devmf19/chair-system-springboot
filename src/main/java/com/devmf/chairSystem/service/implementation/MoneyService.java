package com.devmf.chairSystem.service.implementation;

import com.devmf.chairSystem.dto.MoneyDto;
import com.devmf.chairSystem.repository.MoneyRepository;
import com.devmf.chairSystem.service.interfaces.IMoneyService;
import com.devmf.chairSystem.util.mapper.MoneyMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MoneyService implements IMoneyService {
    private final MoneyRepository moneyRepository;
    private final MoneyMapper moneyMapper;

    @Override
    public List<MoneyDto> getAllMoneys() {
        return moneyRepository.findAll()
                .stream()
                .map(moneyMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public MoneyDto getMoneyById(long id) {
        return moneyRepository.findById(id)
                .map(moneyMapper::entityToDto)
                .orElse(null);
    }

    @Override
    public void saveMoney(MoneyDto moneyDto) {
        moneyRepository.save(
                moneyMapper.dtoToEntity(moneyDto)
        );
    }

    @Override
    public void updateMoney(MoneyDto moneyDto) {
        moneyRepository.save(
                moneyMapper.dtoToEntity(moneyDto)
        );
    }

    @Override
    public void deleteMoney(MoneyDto moneyDto) {
        moneyRepository.delete(
                moneyMapper.dtoToEntity(moneyDto)
        );
    }
}
