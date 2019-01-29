package com.example.ktzb.controller;

import com.example.ktzb.entity.ProductInfo;
import com.example.ktzb.service.ProductInfoService;
import com.example.ktzb.util.DownloadImage;
import com.example.ktzb.util.InfoGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class GetConInfoController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Resource
    private ProductInfoService productInfoService;

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




    @RequestMapping("/getProductList")
    @ResponseBody
    public List<ProductInfo> getProductList(ProductInfo productInfo) throws Exception {
        log.info("***** productInfo *****="+productInfo.toString());
        Map<String,String> resutl = InfoGeneration.infoByJd(productInfo.getProductCode());
        return  productInfoService.getProductList(productInfo);
    }


}
