package com.devmf.chairSystem.Service.interfaces;

import com.devmf.chairSystem.model.Money;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface IMoneyService {
    public List<Money> getMoneys();

    public Optional<Money> getMoneyById(long id);

    public void saveMoney(Money money);

    public void updateMoney(Money money);

    public void deleteMoney(Money money);
}
