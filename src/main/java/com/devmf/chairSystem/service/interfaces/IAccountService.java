package com.devmf.chairSystem.service.interfaces;

import com.devmf.chairSystem.dto.AccountDto;
import com.devmf.chairSystem.model.Account;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IAccountService {
    List<AccountDto> getAllAccounts();

    AccountDto getAccountById(long id);

    Account getAccountByNumber(String accountNumber);

    Account saveAccount(Account account);

    void updateAccount(AccountDto accountDto);
}
