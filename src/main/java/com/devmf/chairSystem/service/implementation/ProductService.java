package com.devmf.chairSystem.service.implementation;

import com.devmf.chairSystem.dto.ProductDto;
import com.devmf.chairSystem.repository.ProductRepository;
import com.devmf.chairSystem.service.interfaces.IProductService;
import com.devmf.chairSystem.util.mapper.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {

    private ProductRepository productRepository;

    private ProductMapper productMapper;


    @Override
    public List<ProductDto> getProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(long id) {
        return productRepository.findById(id)
                .map(productMapper::entityToDto)
                .orElse(null);
    }

    @Override
    public void saveProduct(ProductDto productDto) {
        productRepository.save(
                productMapper.dtoToEntity(productDto)
        );
    }

    @Override
    public void updateProduct(ProductDto productDto) {
        productRepository.save(
                productMapper.dtoToEntity(productDto)
        );
    }

    @Override
    public void deleteProduct(ProductDto productDto) {
        productRepository.save(
                productMapper.dtoToEntity(productDto)
        );
    }

    @Override
    public List<Map<String, Object>> availableProducts(String initialDate, String endDate) {
        return productRepository.availableProducts(initialDate, endDate);
    }

    @Override
    public boolean validateProduct(ProductDto productDto) {
        return productDto == null;
    }
}
