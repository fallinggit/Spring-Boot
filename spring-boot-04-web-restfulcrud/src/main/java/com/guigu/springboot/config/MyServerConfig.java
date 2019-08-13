package com.guigu.springboot.config;

import com.guigu.springboot.filter.MyFilter;
import com.guigu.springboot.listener.MyListener;
import com.guigu.springboot.servlet.MyServlet;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MyServerConfig {

    //注册三大组件
    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(), "/myservlet");
        registrationBean.setLoadOnStartup(1);//启动顺序
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));//转为集合
        return registrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean<>(new MyListener());
        return registrationBean;
    }

//    @Configuration
//    public class TomcatCustomizer {
//
//        //配置嵌入式的Servelet容器
//        @Bean
//        public ConfigurableServletWebServerFactory configurableServletWebServerFactory(){
//            TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
//            factory.setPort(8083);
//            return factory;
//        }
//    }
}
