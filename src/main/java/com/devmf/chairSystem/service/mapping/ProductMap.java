package com.devmf.chairSystem.service.mapping;

import com.devmf.chairSystem.dto.ProductDto;
import com.devmf.chairSystem.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMap {
    public ProductDto entityToDto(Product product) {
        if(product == null ) {
            return null;
        }
        ProductDto productDto = new ProductDto();

        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setAmount(product.getAmount());
        productDto.setStock(product.getStock());

        return  productDto;
    }

    public Product dtoToEntity(ProductDto productDto) {
        if(productDto == null ) {
            return null;
        }
        Product product = new Product();

        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setAmount(productDto.getAmount());
        product.setStock(productDto.getStock());

        return  product;
    }
}
