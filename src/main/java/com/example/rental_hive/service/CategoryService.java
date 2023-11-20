package com.example.rental_hive.service;


import com.example.rental_hive.domain.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CategoryService {

    public Category save(Category category);

    public List<Category> findAll();

    public Optional<Category> findById(Long id);

    public Category update(Category categoryUpdated);

    public void delete(Category category);

}
