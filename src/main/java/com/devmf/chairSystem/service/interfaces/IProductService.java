package com.devmf.chairSystem.service.interfaces;

import com.devmf.chairSystem.dto.ProductDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface IProductService {
    public List<ProductDto> getProducts();

    public Optional<ProductDto> getProductById(long id);

    public void saveProduct(ProductDto productDto);

    public void updateProduct(ProductDto productDto);

    public void deleteProduct(ProductDto productDto);
}
