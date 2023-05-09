package com.devmf.chairSystem.service.implementation;

import com.devmf.chairSystem.dto.AccountDto;
import com.devmf.chairSystem.model.Account;
import com.devmf.chairSystem.repository.AccountRepository;
import com.devmf.chairSystem.service.interfaces.IAccountService;
import com.devmf.chairSystem.util.mapper.AccountMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountService implements IAccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Override
    public List<AccountDto> getAllAccounts() {
        return accountRepository.findAll()
                .stream()
                .map(accountMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public AccountDto getAccountById(long id) {
        return accountRepository.findById(id)
                .map(accountMapper::entityToDto)
                .orElse(null);
    }

    @Override
    public Account getAccountByNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void updateAccount(AccountDto accountDto) {
        accountRepository.save(accountMapper.dtoToEntity(accountDto));
    }
}
