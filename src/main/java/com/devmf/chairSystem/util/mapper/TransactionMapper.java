package com.devmf.chairSystem.util.mapper;

import com.devmf.chairSystem.dto.TransactionDto;
import com.devmf.chairSystem.model.Transaction;
import com.devmf.chairSystem.service.implementation.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {
    @Autowired
    private AccountService accountService;

    public TransactionDto entityToDto(Transaction transaction) {
        return transaction == null
                ? null
                : new TransactionDto(
                transaction.getId(),
                transaction.getType(),
                transaction.getAmount(),
                transaction.getMessage(),
                transaction.getAccount().getAccountNumber(),
                transaction.getEventDetailId(),
                transaction.getCreatedAt()
        );
    }

    public Transaction dtoToEntity(TransactionDto transactionDto) {
        return transactionDto == null
                ? null
                : new Transaction(
                transactionDto.getId(),
                transactionDto.getType(),
                transactionDto.getAmount(),
                transactionDto.getMessage(),
                transactionDto.getEventDetailId(),
                accountService.getAccountByNumber(transactionDto.getAccountNumber())
        );
    }
}
