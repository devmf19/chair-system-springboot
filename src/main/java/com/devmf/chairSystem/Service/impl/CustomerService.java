package com.devmf.chairSystem.Service.impl;

import com.devmf.chairSystem.Service.interfaces.ICustomerService;
import com.devmf.chairSystem.model.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerService implements ICustomerService {
    @Override
    public List<Customer> getCustomers() {
        return null;
    }

    @Override
    public Optional<Customer> getCustomerById(long id) {
        return Optional.empty();
    }

    @Override
    public void saveCustomer(Customer customer) {

    }

    @Override
    public void updateCustomer(Customer customer) {

    }

    @Override
    public void deleteCustomer(Customer customer) {

    }
}
