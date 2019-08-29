package com.guigu.springboot.config;

import com.guigu.springboot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 指明当前类是一个配置类，代替之前的Spring配置文件
 *
 *
 */
@Configuration
public class MyAppConfig {

    //将方法的返回值添加到容器中，容器中组件的默认id就是方法名
    @Bean
    public HelloService helloService(){
        System.out.println("配置类@Bean给容器添加了组件");
        return new HelloService();
    }
}
