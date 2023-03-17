package com.devmf.chairSystem.service.mapping;

import com.devmf.chairSystem.dto.CustomerDto;
import com.devmf.chairSystem.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMap {
    public CustomerDto entityToDto(Customer customer) {
        if(customer == null ) {
            return null;
        }
        CustomerDto customerDto = new CustomerDto();

        customerDto.setId(customer.getId());
        customerDto.setDui(customer.getDui());
        customerDto.setName(customer.getName());
        customerDto.setLastname(customer.getLastname());
        customerDto.setPhone(customer.getPhone());
        customerDto.setAddress(customer.getAddress());
        customerDto.setEmail(customer.getEmail());

        return customerDto;
    }

    public Customer dtoToEntity(CustomerDto customerDto) {
        if(customerDto == null ) {
            return null;
        }
        Customer customer = new Customer();

        customer.setId(customerDto.getId());
        customer.setDui(customerDto.getDui());
        customer.setName(customerDto.getName());
        customer.setLastname(customerDto.getLastname());
        customer.setPhone(customerDto.getPhone());
        customer.setAddress(customerDto.getAddress());
        customer.setEmail(customerDto.getEmail());

        return customer;
    }
}
