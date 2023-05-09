package com.devmf.chairSystem.service.interfaces;

import com.devmf.chairSystem.dto.MoneyDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IMoneyService {
    List<MoneyDto> getAllMoneys();

    MoneyDto getMoneyById(long id);

    void saveMoney(MoneyDto moneyDto);

    void updateMoney(MoneyDto moneyDto);

    void deleteMoney(MoneyDto moneyDto);
}
