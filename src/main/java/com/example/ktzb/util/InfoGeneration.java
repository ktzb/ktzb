package com.example.ktzb.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class InfoGeneration {

    private static final Logger log = LoggerFactory.getLogger(InfoGeneration.class);



    //根据url获取标题与首页图片
    public static Map<String,String> infoByJd(String productCode) throws IOException {
        Map<String,String> resultMap = new HashMap<>();
        resultMap.put("status","F");
        String url = "https://item.jd.com/"+productCode+".html";
        Document doc = Jsoup.connect(url).get();
        Element result = doc.getElementById("spec-img");
        resultMap.put("url",url);
        if(null != result ){
            Element pElement = result.getElementById("spec-img");
            resultMap.put("status","S");
            resultMap.put("imgUrl",result.attr("data-origin"));
            resultMap.put("title",result.attr("alt"));
            log.info("***** resultMap *****："+resultMap.toString());
        }
        return resultMap;
    }

}
