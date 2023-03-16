package com.devmf.chairSystem.service.interfaces;

import com.devmf.chairSystem.dto.CustomerDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ICustomerService {
    public List<CustomerDto> getCustomers();

    public Optional<CustomerDto> getCustomerById(long id);

    public void saveCustomer(CustomerDto customerDto);

    public void updateCustomer(CustomerDto customerDto);

    public void deleteCustomer(CustomerDto customerDto);
}
