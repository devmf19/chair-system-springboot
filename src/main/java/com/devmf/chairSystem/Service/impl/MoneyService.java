package com.devmf.chairSystem.Service.impl;

import com.devmf.chairSystem.Service.interfaces.IMoneyService;
import com.devmf.chairSystem.model.Money;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MoneyService implements IMoneyService {
    @Override
    public List<Money> getMoneys() {
        return null;
    }

    @Override
    public Optional<Money> getMoneyById(long id) {
        return Optional.empty();
    }

    @Override
    public void saveMoney(Money money) {

    }

    @Override
    public void updateMoney(Money money) {

    }

    @Override
    public void deleteMoney(Money money) {

    }
}
