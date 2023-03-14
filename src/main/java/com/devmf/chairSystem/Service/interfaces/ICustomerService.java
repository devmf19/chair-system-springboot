package com.devmf.chairSystem.Service.interfaces;

import com.devmf.chairSystem.model.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ICustomerService {
    public List<Customer> getCustomers();

    public Optional<Customer> getCustomerById(long id);

    public void saveCustomer(Customer customer);

    public void updateCustomer(Customer customer);

    public void deleteCustomer(Customer customer);
}
