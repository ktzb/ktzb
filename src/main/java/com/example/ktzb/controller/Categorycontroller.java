package com.example.ktzb.controller;

import com.example.ktzb.entity.Category;
import com.example.ktzb.entity.ProductInfo;
import com.example.ktzb.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Categorycontroller {

    private static final Logger log = LoggerFactory.getLogger(Categorycontroller.class);


    @Autowired
    private CategoryService categoryService;

    //获取所有类目
    @RequestMapping("/getProductByCategory")
    @ResponseBody
    public List<Category> getCategoryList(Category category) throws Exception {
        log.info("***** getProductByCategory *****="+category.toString());
        return  categoryService.getCategoryList(category);
    }

}
