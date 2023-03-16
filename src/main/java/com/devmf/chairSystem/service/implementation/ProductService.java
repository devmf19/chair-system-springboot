package com.devmf.chairSystem.service.implementation;

import com.devmf.chairSystem.dto.ProductDto;
import com.devmf.chairSystem.repository.ProductRepository;
import com.devmf.chairSystem.service.interfaces.IProductService;
import com.devmf.chairSystem.service.mapping.ProductMap;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    private ProductMap productMap = new ProductMap();


    @Override
    public List<ProductDto> getProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMap::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductDto> getProductById(long id) {
        return Optional.of(
                productMap.entityToDto(
                        productRepository.findById(id).get()
                )
        );
    }

    @Override
    public void saveProduct(ProductDto productDto) {
        productRepository.save(
                productMap.dtoToEntity(productDto)
        );
    }

    @Override
    public void updateProduct(ProductDto productDto) {
        productRepository.save(
                productMap.dtoToEntity(productDto)
        );
    }

    @Override
    public void deleteProduct(ProductDto productDto) {
        productRepository.save(
                productMap.dtoToEntity(productDto)
        );
    }
}
