package com.devmf.chairSystem.Service.interfaces;

import com.devmf.chairSystem.model.Category;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ICategoryService {
    public List<Category> getCategories();

    public Optional<Category> getCategoryById(long id);

    public void saveCategory(Category category);

    public void updateCategory(Category category);

    public void deleteCategory(Category category);
}
