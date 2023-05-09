package com.devmf.chairSystem.service.interfaces;

import com.devmf.chairSystem.dto.ProductDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface IProductService {
    List<ProductDto> getAllProducts();

    ProductDto getProductById(long id);

    void saveProduct(ProductDto productDto);

    void updateProduct(ProductDto productDto);

    void deleteProduct(ProductDto productDto);

    List<Map<String, Object>> availableProducts(String initialDate, String endDate);

    boolean validateProduct(ProductDto productDto);

}
