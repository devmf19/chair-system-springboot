package com.devmf.chairSystem.service.implementation;

import com.devmf.chairSystem.dto.CustomerDto;
import com.devmf.chairSystem.model.Account;
import com.devmf.chairSystem.model.Customer;
import com.devmf.chairSystem.repository.CustomerRepository;
import com.devmf.chairSystem.service.interfaces.ICustomerService;
import com.devmf.chairSystem.util.mapper.AccountMapper;
import com.devmf.chairSystem.util.mapper.CustomerMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerService implements ICustomerService {
    private CustomerRepository customerRepository;
    private final AccountService accountService;
    private final CustomerMapper customerMapper;
    private final AccountMapper accountMapper;

    @Override
    public List<CustomerDto> getCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Customer getCustomerByDui(String dui) {
        return customerRepository.findByDui(dui);
    }

    @Override
    public void saveCustomer(CustomerDto customerDto) {
        Account account = accountService.saveAccount(new Account(customerDto.getDui(), 0, Collections.emptyList()));
        customerDto.setAccount(accountMapper.entityToDto(account));

        customerRepository.save(customerMapper.dtoToEntity(customerDto));
    }

    @Override
    public void updateCustomer(String dui, CustomerDto customerDto) {
        Customer customer = customerRepository.findByDui(dui);
        customer.setDui(customerDto.getDui());
        customer.setName(customerDto.getName());
        customer.setLastname(customerDto.getLastname());
        customer.setPhone(customerDto.getPhone());
        customer.setAddress(customerDto.getAddress());
        customer.setEmail(customerDto.getEmail());
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(String dui) {
        Customer customer = getCustomerByDui(dui);
        customerRepository.delete(customer);
    }

    public boolean validateCustomer(CustomerDto customerDto) {
        return customerDto == null;
    }
}
