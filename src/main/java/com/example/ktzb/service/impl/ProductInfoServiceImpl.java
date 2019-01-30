package com.example.ktzb.service.impl;

import com.example.ktzb.dao.ProductInfoDao;
import com.example.ktzb.entity.ProductInfo;
import com.example.ktzb.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInfoServiceImpl implements ProductInfoService{

    @Autowired
    private ProductInfoDao productInfoDao;

    @Override
    public Long addProductInfo(ProductInfo productInfo) {
        return productInfoDao.addProductInfo(productInfo);
    }

    @Override
    public List<ProductInfo> getProductList(ProductInfo productInfo) {
        return productInfoDao.getProductList(productInfo);
    }

    @Override
    public List<ProductInfo> getProductByCategory(ProductInfo productInfo) {
        return productInfoDao.getProductByCategory(productInfo);
    }
}
