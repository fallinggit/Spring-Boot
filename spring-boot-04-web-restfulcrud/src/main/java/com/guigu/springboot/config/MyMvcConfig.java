package com.guigu.springboot.config;

import com.guigu.springboot.component.LoginHandlerInterceptor;
import com.guigu.springboot.component.MyLocaleResolver;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
//import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

//使用WebMvcConfigurerAdapter可以扩展SpringMVC的功能
//@EnableWebMvc //全面接管MVC，SpringBoot对SpringMvc的自动配置舍弃，自己手动配置
@Configuration
//方法一
public class MyMvcConfig extends WebMvcConfigurerAdapter{

    //springboot2.x版本
    @Configuration
    public class TomcatCustomizer {

        @Bean
        public ConfigurableServletWebServerFactory configurableServletWebServerFactory(){
            TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
            factory.setPort(8585);
            return factory;
        }
    }

    @Override//验证方法是否为父类所拥有
    public void addViewControllers(ViewControllerRegistry registry) {
//      super.addViewControllers(registry);
        //浏览器发送 /guigu 请求来到success页面
        registry.addViewController("/guigu").setViewName("success");
    }

    //所有的WebMvcConfigurerAdapter组件会一起起作用
    @Bean //将组件注册到容器中
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                //添加视图映射
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }


            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //super.addInterceptors(registry);
                // "/**"表示拦截任意路径下的任意请求
                //SpringBoot已经做好了静态资源映射
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                        .excludePathPatterns("/index.html","/","/user/login");
            }
        };
        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

}
/**
 * extends 继承类；implements 实现接口
 * 类有程序实现，接口预定义方法
 */
//方法二
//public class MyMvcConfig implements WebMvcConfigurer {
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
////      super.addViewControllers(registry);
//        //浏览器发送 /guigu 请求来到success页面
//        registry.addViewController("/guigu").setViewName("success");
//    }
//}

//方法三
//public class MyMvcConfig extends WebMvcConfigurationSupport {
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/guigu").setViewName("success");
//    }
//}