package com.devmf.chairSystem.service.mapping;

import com.devmf.chairSystem.dto.MoneyDto;
import com.devmf.chairSystem.model.Money;
import org.springframework.stereotype.Component;

@Component
public class MoneyMap {

    public MoneyDto entityToDto(Money money){
        if(money == null ) {
            return null;
        }
        MoneyDto moneyDto = new MoneyDto(
                money.getId(),
                money.getShortName(),
                money.getName()
        );

        return moneyDto;
    }

    public Money dtoToEntity(MoneyDto moneyDto) {
        if(moneyDto == null ) {
            return null;
        }
        Money money = new Money(
                moneyDto.getId(),
                moneyDto.getShortName(),
                moneyDto.getName()
        );

        return money;
    }
}
