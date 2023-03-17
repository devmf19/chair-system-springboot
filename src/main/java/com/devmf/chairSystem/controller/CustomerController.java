package com.devmf.chairSystem.controller;

import com.devmf.chairSystem.dto.CustomerDto;
import com.devmf.chairSystem.dto.Message;
import com.devmf.chairSystem.service.implementation.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;

    @GetMapping("")
    public ResponseEntity<List<CustomerDto>> customersList(){
        return new ResponseEntity<>(
                customerService.getCustomers(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable("id") long id) {
        CustomerDto customerDto = customerService.getCustomerById(id);
        return customerDto == null ?
                new ResponseEntity<>(new Message("Not found customer"), HttpStatus.BAD_REQUEST)
                : new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> saveCustomer(@RequestBody CustomerDto customerDto) {
        customerService.saveCustomer(customerDto);
        return  new ResponseEntity<>(new Message("Saved customer"), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable("id") long id, @RequestBody CustomerDto customerDto) {
        CustomerDto c = customerService.getCustomerById(id);
        if(c == null){
            return new ResponseEntity<>(new Message("Not found customer"), HttpStatus.BAD_REQUEST);
        }
        customerDto.setId(c.getId());
        customerService.updateCustomer(customerDto);
        return  new ResponseEntity<>(new Message("Updated customer"), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") long id) {
        CustomerDto customerDto = customerService.getCustomerById(id);
        if(customerDto == null){
            return new ResponseEntity<>(new Message("Not found customer"), HttpStatus.BAD_REQUEST);
        }
        customerService.deleteCustomer(customerDto);
        return  new ResponseEntity<>(new Message("Deleted customer"), HttpStatus.OK);
    }
}
