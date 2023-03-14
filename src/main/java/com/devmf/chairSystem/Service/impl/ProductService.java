package com.devmf.chairSystem.Service.impl;

import com.devmf.chairSystem.Service.interfaces.IProductService;
import com.devmf.chairSystem.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService implements IProductService {
    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public Optional<Product> getProductById(long id) {
        return Optional.empty();
    }

    @Override
    public void saveProduct(Product product) {

    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void deleteProduct(Product product) {

    }
}
