package com.arrowsModule.expenseTracker.service.impl;

import com.arrowsModule.expenseTracker.dao.CategoryDao;
import com.arrowsModule.expenseTracker.exception.NotFoundException;
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
    public Category findById(Long id) throws NotFoundException {
        return categoryDao.findById(id).orElseThrow(()->new NotFoundException("No such category"));
    }

    @Override
    public List<Category> findAllByUserId(Long uId) throws NotFoundException {
        return categoryDao.findAllByUserId(uId).orElseThrow(()->new NotFoundException("No such user"));
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
    public String delete(Long catId) throws NotFoundException {
        Category category = categoryDao.findById(catId).orElseThrow(()->new NotFoundException("No such user"));
        categoryDao.delete(category);
        return "Category has been removed";
    }
}
