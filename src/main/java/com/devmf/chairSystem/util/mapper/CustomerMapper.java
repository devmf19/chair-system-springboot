package com.devmf.chairSystem.util.mapper;

import com.devmf.chairSystem.dto.CustomerDto;
import com.devmf.chairSystem.model.Customer;
import com.devmf.chairSystem.service.implementation.AccountService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    @Autowired
    private AccountService accountService;
    private final AccountMapper accountMapper = new AccountMapper();

    public CustomerDto entityToDto(Customer customer) {
        return customer == null
                ? null
                : new CustomerDto(
                customer.getDui(),
                customer.getName(),
                customer.getLastname(),
                customer.getPhone(),
                customer.getAddress(),
                customer.getEmail(),
                accountMapper.entityToDto(customer.getAccount())
        );
    }

    public Customer dtoToEntity(CustomerDto customerDto) {
        return customerDto == null
                ? null
                : new Customer(
                customerDto.getDui(),
                customerDto.getName(),
                customerDto.getLastname(),
                customerDto.getPhone(),
                customerDto.getAddress(),
                customerDto.getEmail(),
                accountService.getAccountByNumber(customerDto.getDui())
        );
    }
}
