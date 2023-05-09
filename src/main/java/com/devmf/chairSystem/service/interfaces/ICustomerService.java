package com.devmf.chairSystem.service.interfaces;

import com.devmf.chairSystem.dto.CustomerDto;
import com.devmf.chairSystem.model.Customer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ICustomerService {
    List<CustomerDto> getCustomers();

    Customer getCustomerByDui(String dui);

    void saveCustomer(CustomerDto customerDto);

    void updateCustomer(String dui, CustomerDto customerDto);

    void deleteCustomer(String dui);

}
