package com.guigu.springboot.controller;

import com.guigu.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

//要成为异常处理器，需要@ControllerAdvice
@ControllerAdvice
public class MyExceptionHandler {

    //浏览器、客户端返回的都是json数据
    //UserNotExistException可更换为Exception，即处理所有异常
//    @ResponseBody//响应json数据
//    @ExceptionHandler(UserNotExistException.class)//处理异常需要的注解
//    public Map<String,Object> handleException(Exception e){
//
//        //响应自己的json数据
//        Map<String,Object> map = new HashMap<>();
//        map.put("code","user.notexist");
//        map.put("message",e.getMessage());
//        return map;//应该返回Map<String,Object>的json数据，否则会报红
//    }

    @ExceptionHandler(UserNotExistException.class)//处理异常需要的注解
    public String handleException(Exception e, HttpServletRequest request) {//使用String产生自适应效果
        Map<String, Object> map = new HashMap<>();
        //传入我们自己的错误状态码 4xx 5xx 否则就不会进入定制错误页面的解析流程
        /**
         * Integer statusCode = (Integer) request
         * .getAttribute("javax.servlet.error.status_code");
         */
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code", "user.notexist");
        map.put("message", "用户出错");
        request.setAttribute("ext",map);
        //转发到error
        return "forward:/error";
    }
}
