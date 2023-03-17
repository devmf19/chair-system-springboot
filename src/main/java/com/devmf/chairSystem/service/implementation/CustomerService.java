package com.devmf.chairSystem.service.implementation;

import com.devmf.chairSystem.dto.CustomerDto;
import com.devmf.chairSystem.repository.CustomerRepository;
import com.devmf.chairSystem.service.interfaces.ICustomerService;
import com.devmf.chairSystem.service.mapping.CustomerMap;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerService implements ICustomerService {

    private CustomerRepository customerRepository;

    private final CustomerMap customerMap;

    @Override
    public List<CustomerDto> getCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMap::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDto getCustomerById(long id) {
        return customerRepository.findById(id)
                .map(customerMap::entityToDto)
                .orElse(null);
    }

    @Override
    public void saveCustomer(CustomerDto customerDto) {
        customerRepository.save(
                customerMap.dtoToEntity(customerDto)
        );
    }

    @Override
    public void updateCustomer(CustomerDto customerDto) {
        customerRepository.save(
                customerMap.dtoToEntity(customerDto)
        );
    }

    @Override
    public void deleteCustomer(CustomerDto customerDto) {
        customerRepository.delete(
                customerMap.dtoToEntity(customerDto)
        );
    }
}
