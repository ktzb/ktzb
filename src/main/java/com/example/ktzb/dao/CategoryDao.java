package com.example.ktzb.dao;

import com.example.ktzb.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryDao {

    public List<Category> getCategoryList(Category category);



}
