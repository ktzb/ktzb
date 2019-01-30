package com.example.ktzb.service.impl;

import com.example.ktzb.dao.CategoryDao;
import com.example.ktzb.entity.Category;
import com.example.ktzb.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> getCategoryList(Category category) {
        return categoryDao.getCategoryList(category);
    }
}
