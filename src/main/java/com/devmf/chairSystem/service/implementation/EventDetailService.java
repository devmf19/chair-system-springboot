package com.devmf.chairSystem.service.implementation;

import com.devmf.chairSystem.dto.EventDetailDto;
import com.devmf.chairSystem.dto.TransactionDto;
import com.devmf.chairSystem.model.EventDetail;
import com.devmf.chairSystem.repository.EventDetailRepository;
import com.devmf.chairSystem.service.interfaces.IEventDetailService;
import com.devmf.chairSystem.util.mapper.EventDetailMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventDetailService implements IEventDetailService {
    private EventDetailRepository eventDetailRepository;
    private final TransactionService transactionService;
    private final EventService eventService;
    private final ProductService productService;
    private final EventDetailMapper eventDetailMapper;

    @Override
    public EventDetailDto getEventDetailById(long id) {
        return eventDetailRepository.findById(id)
                .map(eventDetailMapper::entityToDto)
                .orElse(null);
    }

    @Override
    public void saveEventDetail(EventDetailDto eventDetailDto) {
        //se guarda el event detail
        EventDetail ed = eventDetailRepository.save(
                eventDetailMapper.dtoToEntity(eventDetailDto)
        );

        //se realiza la transaccion para sumar el valor del event detail a la cuenta del cliente
        transactionService.saveTransaction(
                new TransactionDto(
                        0, //aumenta el saldo de la cuenta del cliente
                        eventDetailDto.getAmount() * eventDetailDto.getPrice(),
                        ed.getEvent().getName(),
                        ed.getEvent().getCustomer().getAccount().getAccountNumber(),
                        ed.getId()
                )
        );
    }

    @Override
    public void updateEventDetail(EventDetailDto eventDetailDto) {
        eventDetailRepository.save(
                eventDetailMapper.dtoToEntity(eventDetailDto)
        );

        //se actualiza el valor de la transaccion que fue creada con el event detail (actualiza el saldo de la cuenta desde un trigger)
        TransactionDto transaction = transactionService.getTransactionByEventDetailId(eventDetailDto.getId());
        transaction.setAmount(eventDetailDto.getAmount() * eventDetailDto.getPrice());
        transactionService.updateTransaction(transaction);
    }

    @Override
    public void deleteEventDetail(EventDetailDto eventDetailDto) {
        eventDetailRepository.delete(
                eventDetailMapper.dtoToEntity(eventDetailDto)
        );

        //delete transacction
        TransactionDto transaction = transactionService.getTransactionByEventDetailId(eventDetailDto.getId());
        transactionService.deleteTransaction(transaction);
    }
}
