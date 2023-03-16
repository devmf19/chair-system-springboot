package com.devmf.chairSystem.service.implementation;

import com.devmf.chairSystem.dto.MoneyDto;
import com.devmf.chairSystem.model.Money;
import com.devmf.chairSystem.repository.MoneyRepository;
import com.devmf.chairSystem.service.interfaces.IMoneyService;
import com.devmf.chairSystem.service.mapping.MoneyMap;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MoneyService implements IMoneyService {

    private final MoneyRepository moneyRepository;
    private final MoneyMap moneyMap;

    @Override
    public List<MoneyDto> getMoneys() {
        return moneyRepository.findAll()
                .stream()
                .map(moneyMap::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public MoneyDto getMoneyById(long id) {
        Money result = moneyRepository.findById(id).orElse(null);
        return result == null ?
                null
                : moneyMap.entityToDto(result);
    }

    @Override
    public void saveMoney(MoneyDto moneyDto) {
        moneyRepository.save(
                moneyMap.dtoToEntity(moneyDto)
        );
    }

    @Override
    public void updateMoney(MoneyDto moneyDto) {
        moneyRepository.save(
                moneyMap.dtoToEntity(moneyDto)
        );
    }

    @Override
    public void deleteMoney(MoneyDto moneyDto) {
        moneyRepository.delete(
                moneyMap.dtoToEntity(moneyDto)
        );
    }
}
