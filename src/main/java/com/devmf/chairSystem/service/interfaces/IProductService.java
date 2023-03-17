package com.devmf.chairSystem.service.interfaces;

import com.devmf.chairSystem.dto.ProductDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IProductService {
    List<ProductDto> getProducts();

    ProductDto getProductById(long id);

    void saveProduct(ProductDto productDto);

    void updateProduct(ProductDto productDto);

    void deleteProduct(ProductDto productDto);
}
