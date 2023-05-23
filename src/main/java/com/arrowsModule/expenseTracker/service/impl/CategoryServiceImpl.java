package com.arrowsModule.expenseTracker.service.impl;

import com.arrowsModule.expenseTracker.dao.CategoryDao;
import com.arrowsModule.expenseTracker.model.Category;
import com.arrowsModule.expenseTracker.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;
    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryDao.findById(id).orElseThrow();
    }

    @Override
    public List<Category> findAllByUserId(Long uId) {
        return categoryDao.findAllByUserId(uId);
    }

    @Override
    public String save(Category category) {
        if(categoryDao.existsById(category.getCatId())){
            categoryDao.save(category);
            return "new category has updated";
        }
        categoryDao.save(category);
        return "new category has saved";
    }

    @Override
    public String delete(Long catId) {
        Category category = categoryDao.getById(catId);
        categoryDao.delete(category);
        return "Category has been removed";
    }
}
