package com.arrowsModule.expenseTracker.service;

import com.arrowsModule.expenseTracker.model.Category;
import com.arrowsModule.expenseTracker.model.Record;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService {
    public List<Category> findAll();
    public Category findById(Long id);
    public List<Category> findAllByUserId(Long uId);
    public String save(Category category);
    public String delete(Long catId);
}
