package com.example.ktzb.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.ktzb.entity.User;
import com.example.ktzb.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private UserService userService;



    @RequestMapping("/hello")
    public String index() {
        return"Hello World";
    }


    @RequestMapping("/get")
    @ResponseBody
    public String get(User user) {
        log.info("***** user ***** = "+user.toString());
        User u=userService.getNameById(user);
        log.info("***** u ***** = "+u.toString());
        return JSONObject.toJSONString(u);
    }


}
