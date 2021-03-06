package com.example.ktzb.controller;

import com.example.ktzb.entity.ProductInfo;
import com.example.ktzb.service.ProductInfoService;
import com.example.ktzb.util.DownloadImage;
import com.example.ktzb.util.InfoGeneration;
import com.example.ktzb.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class ProductInfoController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Resource
    private ProductInfoService productInfoService;


    //创建产品信息并插入表
    @RequestMapping("/createProductInfo")
    @ResponseBody
    public ProductInfo createProductInfo(ProductInfo productInfo) throws Exception {
        log.info("***** productInfo *****="+productInfo.toString());
        Map<String,String> resutl = InfoGeneration.infoByJd(productInfo.getProductCode());
        if(resutl.get("status").equals("S")){
            String path = "c:\\image\\";
            String filename = productInfo.getProductCode()+".jpg";
            String imgUrl = "http:"+resutl.get("imgUrl");
            DownloadImage.download(imgUrl,filename,path);
            //封装插入的参数
            productInfo.setName(resutl.get("title"));
            productInfo.setImgUrl(resutl.get("imgUrl"));
            productInfo.setImgPath(path+filename);
            Long id =  productInfoService.addProductInfo(productInfo);
            log.info("***** productInfo end *****="+id);
        }

        return productInfo;
    }



    //获取所有产品
    @RequestMapping("/getProductList")
    @ResponseBody
    public List<ProductInfo> getProductList(ProductInfo productInfo) throws Exception {
        log.info("***** getProductList *****="+productInfo.toString());
        Map<String,String> resutl = InfoGeneration.infoByJd(productInfo.getProductCode());
        return  productInfoService.getProductList(productInfo);
    }



    //根据类目获取产品
    @RequestMapping("/getProductByCategory")
    @ResponseBody
    public List<ProductInfo> getProductByCategory(ProductInfo productInfo) throws Exception {
        log.info("***** getProductByCategory *****="+productInfo.toString());
        return  productInfoService.getProductByCategory(productInfo);
    }



/*
    //根据产品code获取数据库是否存在一样的产品编码的并且价格是最低的
    private ProductInfo getLowPrice(String productCode){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductCode(productCode);
        return productInfoService.getLowPrice(productInfo);
    }
*/





}
