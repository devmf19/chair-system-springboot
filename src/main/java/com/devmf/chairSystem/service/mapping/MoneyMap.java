package com.devmf.chairSystem.service.mapping;

import com.devmf.chairSystem.dto.MoneyDto;
import com.devmf.chairSystem.model.Money;
import org.springframework.stereotype.Component;

@Component
public class MoneyMap {

    public MoneyDto entityToDto(Money money){
        MoneyDto moneyDto = new MoneyDto();

        moneyDto.setId(money.getId());
        moneyDto.setShortName(money.getShortName());
        moneyDto.setName(money.getName());

        return moneyDto;
    }

    public Money dtoToEntity(MoneyDto moneyDto) {
        Money money = new Money();

        money.setId(moneyDto.getId());
        money.setShortName(moneyDto.getShortName());
        money.setName(moneyDto.getName());

        return money;
    }
}
