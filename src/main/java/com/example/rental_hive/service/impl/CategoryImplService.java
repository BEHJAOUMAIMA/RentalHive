package com.example.rental_hive.service.impl;

import com.example.rental_hive.domain.Category;
import com.example.rental_hive.repository.CategoryRepository;
import com.example.rental_hive.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CategoryImplService implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category update(Category categoryUpdated) {
        Optional<Category> category = categoryRepository.findById(categoryUpdated.getId());
        if (category.isPresent()){
            return categoryRepository.save(categoryUpdated);
        }
        return null;
    }

    @Override
    public void delete(Category category) {
        categoryRepository.delete(category);
    }
}
