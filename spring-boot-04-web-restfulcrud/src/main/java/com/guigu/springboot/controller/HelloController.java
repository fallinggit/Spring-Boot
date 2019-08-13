package com.guigu.springboot.controller;

import com.guigu.springboot.exception.UserNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

//    @RequestMapping({"/","/index.html"})//控制类，控制url路径
//    public String index() {
//        return "index";
//    }

    @ResponseBody
    @RequestMapping("/hello")
    //从请求参数获取值,用@RequestParam("user")
    public String hello(@RequestParam("user") String user) {
        if (user.equals("aaa")){
            throw new UserNotExistException();
        }
        return "Hello World";
    }

    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("hello", "<h1>你好</h1>");
        map.put("users", Arrays.asList("Tom", "David", "Mary"));
        return "success";
    }

}
