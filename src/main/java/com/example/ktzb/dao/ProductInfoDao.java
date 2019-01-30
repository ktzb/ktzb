package com.example.ktzb.dao;

import com.example.ktzb.entity.ProductInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductInfoDao {

    public Long addProductInfo(ProductInfo productInfo);

    public List<ProductInfo> getProductList(ProductInfo productInfo);

    public List<ProductInfo> getProductByCategory(ProductInfo productInfo);



}
