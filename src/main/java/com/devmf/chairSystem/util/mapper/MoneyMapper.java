package com.devmf.chairSystem.util.mapper;

import com.devmf.chairSystem.dto.MoneyDto;
import com.devmf.chairSystem.model.Money;
import org.springframework.stereotype.Component;

@Component
public class MoneyMapper {

    public MoneyDto entityToDto(Money money) {
        return money == null
                ? null
                : new MoneyDto(
                money.getId(),
                money.getShortName(),
                money.getName()
        );
    }

    public Money dtoToEntity(MoneyDto moneyDto) {
        return moneyDto == null
                ? null
                : new Money(
                moneyDto.getId(),
                moneyDto.getShortName(),
                moneyDto.getName()
        );
    }
}
