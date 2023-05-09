package com.devmf.chairSystem.util.mapper;

import com.devmf.chairSystem.dto.ProductDto;
import com.devmf.chairSystem.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductDto entityToDto(Product product) {
        return product == null
            ? null
            : new ProductDto(
                product.getId(),
                product.getName(),
                product.getAmount(),
                product.getAmount()
            );
    }

    public Product dtoToEntity(ProductDto productDto) {
        return productDto == null
            ? null
            : new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getAmount(),
                productDto.getAmount()
            );
    }
}
