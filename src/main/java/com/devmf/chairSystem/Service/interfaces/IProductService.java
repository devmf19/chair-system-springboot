package com.devmf.chairSystem.Service.interfaces;

import com.devmf.chairSystem.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface IProductService {
    public List<Product> getProducts();

    public Optional<Product> getProductById(long id);

    public void saveProduct(Product product);

    public void updateProduct(Product product);

    public void deleteProduct(Product product);
}
