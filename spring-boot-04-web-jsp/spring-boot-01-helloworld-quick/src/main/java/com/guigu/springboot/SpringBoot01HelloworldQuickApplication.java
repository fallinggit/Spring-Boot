package com.guigu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//默认生成的Spring Boot项目，主程序已生成好，只需编写业务逻辑（controller）

/**
 * resources文件夹目录结构
 * 1.static:保存所有静态资源(ja,css,images);
 * 2.templates:保存所有模板页面(Spring Boot默认jar包使用嵌入式的Tomcat，
 * 默认不支持JSP页面)；可以使用模板引擎(freemarker、thymeleaf);
 * 3.application.properties:Spring Boot用于的配置文件；可以修改一些默认设置
 */
@RestController
@SpringBootApplication
public class SpringBoot01HelloworldQuickApplication {

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String sayHello(){
        return "Hello SpringBoot";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot01HelloworldQuickApplication.class, args);
    }

}
