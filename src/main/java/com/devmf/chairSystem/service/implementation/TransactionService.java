package com.devmf.chairSystem.service.implementation;

import com.devmf.chairSystem.dto.TransactionDto;
import com.devmf.chairSystem.repository.TransactionRepository;
import com.devmf.chairSystem.service.interfaces.ITransactionService;
import com.devmf.chairSystem.util.mapper.TransactionMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class TransactionService implements ITransactionService {
    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    @Override
    public TransactionDto getTransactionById(long id) {
        return transactionRepository.findById(id)
                .map(transactionMapper::entityToDto)
                .orElse(null);
    }

    @Override
    public TransactionDto getTransactionByEventDetailId(long id) {
        return transactionRepository.findAllByEventDetailId(id)
                .map(transactionMapper::entityToDto)
                .orElse(null);
    }

    @Override
    public void saveTransaction(TransactionDto transactionDto) {
        transactionRepository.save(transactionMapper.dtoToEntity(transactionDto));
    }

    @Override
    public void updateTransaction(TransactionDto transactionDto) {
        transactionRepository.save(transactionMapper.dtoToEntity(transactionDto));
    }

    @Override
    public void deleteTransaction(TransactionDto transactionDto) {
        transactionRepository.delete(transactionMapper.dtoToEntity(transactionDto));
    }
}
