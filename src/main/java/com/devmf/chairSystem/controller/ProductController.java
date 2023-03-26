package com.devmf.chairSystem.controller;

import com.devmf.chairSystem.dto.DateRequest;
import com.devmf.chairSystem.dto.Message;
import com.devmf.chairSystem.dto.ProductDto;
import com.devmf.chairSystem.service.implementation.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("")
    public ResponseEntity<?> productsList() {
        return new ResponseEntity<>(
                productService.getProducts(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(@PathVariable("id") long id) {
        ProductDto result = productService.getProductById(id);
        if(productService.validateProduct(result)){
            return  new ResponseEntity<>(new Message("Not found product"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/availables")
    public ResponseEntity<?> availableProducts(@RequestBody DateRequest dateRequest) {
        if(Date.valueOf(dateRequest.getInitialDate()).getTime() > Date.valueOf(dateRequest.getEndDate()).getTime()) {
            return new ResponseEntity<>(new Message("End date can´t be greater than initial date"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(
                productService.availableProducts(dateRequest.getInitialDate(), dateRequest.getEndDate()),
                HttpStatus.OK
        );
    }

    @PostMapping("")
    public ResponseEntity<?> saveProduct(@RequestBody ProductDto productDto) {
        productService.saveProduct(productDto);
        return new ResponseEntity<>(new Message("Saved product"), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable("id") long id, @RequestBody ProductDto productDto) {
        ProductDto result = productService.getProductById(id);
        if(productService.validateProduct(result)){
            return  new ResponseEntity<>(new Message("Not found product"), HttpStatus.NOT_FOUND);
        }
        productDto.setId(result.getId());
        productService.updateProduct(productDto);
        return new ResponseEntity<>(new Message("Updated product"), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") long id) {
        ProductDto result = productService.getProductById(id);
        if(productService.validateProduct(result)){
            return  new ResponseEntity<>(new Message("Not found product"), HttpStatus.NOT_FOUND);
        }
        productService.deleteProduct(result);
        return new ResponseEntity<>(new Message("Deleted product"), HttpStatus.OK);
    }


}
