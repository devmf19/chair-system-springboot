package com.devmf.chairSystem.service.interfaces;

import com.devmf.chairSystem.dto.TransactionDto;
import org.springframework.stereotype.Component;

@Component
public interface ITransactionService {
    TransactionDto getTransactionById(long id);

    TransactionDto getTransactionByEventDetailId(long id);

    void saveTransaction(TransactionDto transactionDto);

    void updateTransaction(TransactionDto transactionDto);

    void deleteTransaction(TransactionDto transactionDto);
}
