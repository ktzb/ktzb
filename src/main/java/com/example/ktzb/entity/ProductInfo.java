package com.example.ktzb.entity;

public class ProductInfo {

    private Long id           ;
    private String name         ;
    private String price        ;
    private String agencyPrice ;
    private String imgPath     ;
    private String imgUrl      ;


    private String productCode;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAgencyPrice() {
        return agencyPrice;
    }

    public void setAgencyPrice(String agencyPrice) {
        this.agencyPrice = agencyPrice;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "ProductInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", agencyPrice='" + agencyPrice + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", productCode='" + productCode + '\'' +
                '}';
    }
}
