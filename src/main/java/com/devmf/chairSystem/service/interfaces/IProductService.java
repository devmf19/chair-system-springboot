package com.devmf.chairSystem.service.interfaces;

import com.devmf.chairSystem.dto.ProductDto;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Component
public interface IProductService {
    List<ProductDto> getProducts();

    ProductDto getProductById(long id);

    void saveProduct(ProductDto productDto);

    void updateProduct(ProductDto productDto);

    void deleteProduct(ProductDto productDto);

    List<Map<String, Object>> availableProducts(String initialDate, String endDate);

    boolean validateProduct(ProductDto productDto);

}
