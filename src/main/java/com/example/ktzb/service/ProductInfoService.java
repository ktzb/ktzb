package com.example.ktzb.service;

import com.example.ktzb.entity.ProductInfo;

import java.util.List;

public interface ProductInfoService {

    public Long addProductInfo(ProductInfo productInfo);


    List<ProductInfo> getProductList(ProductInfo productInfo);

}
