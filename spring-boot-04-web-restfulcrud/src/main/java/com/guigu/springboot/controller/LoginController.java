package com.guigu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

//    @DeleteMapping
//    @PutMapping
//    @GetMapping
//    @PostMapping
    //@RequestMapping(value = "/user/login",method = RequestMethod.POST)
    //Map用来封装错误消息
    @PostMapping(value = "/user/login")
    //标注@RequestParam，如果没收到对应参数会报错
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        if (!StringUtils.isEmpty(username) && "123456".equals(password)){
            //登录成功,防止表单重复提交，可以重定向到主页
            //session 会话控制
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else{
            //登录失败
            map.put("msg","用户名密码错误");
            return "login";
        }
    }
}
