package com.guigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//业务逻辑
@Controller
public class HelloController {

    @ResponseBody//注解
    @RequestMapping("/hello")//接收来自于浏览器的hello请求
    public String hello(){
        return "Hello World";
    }
}
