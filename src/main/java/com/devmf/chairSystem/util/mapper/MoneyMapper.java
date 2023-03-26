package com.devmf.chairSystem.util.mapper;

import com.devmf.chairSystem.dto.MoneyDto;
import com.devmf.chairSystem.model.Money;
import org.springframework.stereotype.Component;

@Component
public class MoneyMapper {

    public MoneyDto entityToDto(Money money){
        if(money == null )
            return null;
        return new MoneyDto(
                money.getId(),
                money.getShortName(),
                money.getName()
        );
    }

    public Money dtoToEntity(MoneyDto moneyDto) {
        if(moneyDto == null )
            return null;

        return new Money(
                moneyDto.getId(),
                moneyDto.getShortName(),
                moneyDto.getName()
        );
    }
}
