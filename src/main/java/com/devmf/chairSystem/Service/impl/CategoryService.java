package com.devmf.chairSystem.Service.impl;

import com.devmf.chairSystem.Service.interfaces.ICategoryService;
import com.devmf.chairSystem.model.Category;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryService implements ICategoryService {
    @Override
    public List<Category> getCategories() {
        return null;
    }

    @Override
    public Optional<Category> getCategoryById(long id) {
        return Optional.empty();
    }

    @Override
    public void saveCategory(Category category) {

    }

    @Override
    public void updateCategory(Category category) {

    }

    @Override
    public void deleteCategory(Category category) {

    }
}
