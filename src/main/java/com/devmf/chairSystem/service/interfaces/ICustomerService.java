package com.devmf.chairSystem.service.interfaces;

import com.devmf.chairSystem.dto.CustomerDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ICustomerService {
    List<CustomerDto> getCustomers();

    CustomerDto getCustomerById(long id);

    void saveCustomer(CustomerDto customerDto);

    void updateCustomer(CustomerDto customerDto);

    void deleteCustomer(CustomerDto customerDto);
}
