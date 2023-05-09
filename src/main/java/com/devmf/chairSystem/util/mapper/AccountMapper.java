package com.devmf.chairSystem.util.mapper;

import com.devmf.chairSystem.dto.AccountDto;
import com.devmf.chairSystem.dto.TransactionDto;
import com.devmf.chairSystem.model.Account;
import com.devmf.chairSystem.model.Transaction;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountMapper {
    public AccountDto entityToDto(Account account) {
        return account == null
                ? null
                : new AccountDto(
                account.getAccountNumber(),
                account.getBalance(),
                transactionsListToDto(account.getTransactions())
        );
    }

    public Account dtoToEntity(AccountDto accountDto) {
        return accountDto == null
                ? null
                : new Account(
                accountDto.getAccountNumber(),
                accountDto.getBalance()
        );
    }

    private List<TransactionDto> transactionsListToDto(List<Transaction> transactions) {
        TransactionMapper transactionMapper = new TransactionMapper();
        if (transactions.isEmpty())
            return Collections.emptyList();
        return transactions
                .stream()
                .map(transactionMapper::entityToDto)
                .collect(Collectors.toList());

    }
}
