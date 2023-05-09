package com.devmf.chairSystem.controller;

import com.devmf.chairSystem.dto.CustomerDto;
import com.devmf.chairSystem.dto.Message;
import com.devmf.chairSystem.service.implementation.CustomerService;
import com.devmf.chairSystem.util.mapper.CustomerMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;
    private  final CustomerMapper customerMapper;

    @GetMapping("")
    public ResponseEntity<?> customersList(){
        return new ResponseEntity<>(
                customerService.getCustomers(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{dui}")
    public ResponseEntity<?> getCustomer(@PathVariable("dui") String dui) {
        CustomerDto customer = customerMapper.entityToDto(customerService.getCustomerByDui(dui));
        return customerService.validateCustomer(customer)
                ? new ResponseEntity<>(new Message("Not found customer"), HttpStatus.BAD_REQUEST)
                : new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> saveCustomer(@RequestBody CustomerDto customerDto) {
        customerService.saveCustomer(customerDto);
        return  new ResponseEntity<>(new Message("Saved customer"), HttpStatus.CREATED);
    }

    @PutMapping("/{dui}")
    public ResponseEntity<?> updateCustomer(@PathVariable("dui") String dui, @RequestBody CustomerDto customerDto) {
        CustomerDto customer = customerMapper.entityToDto(customerService.getCustomerByDui(dui));
        if(customerService.validateCustomer(customer))
            return new ResponseEntity<>(new Message("Not found customer"), HttpStatus.BAD_REQUEST);

        customerService.updateCustomer(dui, customerDto);
        return  new ResponseEntity<>(new Message("Updated customer"), HttpStatus.OK);
    }

    @DeleteMapping("/{dui}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("dui") String dui) {
        CustomerDto customer = customerMapper.entityToDto(customerService.getCustomerByDui(dui));
        if(customerService.validateCustomer(customer))
            return new ResponseEntity<>(new Message("Not found customer"), HttpStatus.BAD_REQUEST);

        customerService.deleteCustomer(dui);
        return  new ResponseEntity<>(new Message("Deleted customer"), HttpStatus.OK);
    }
}
