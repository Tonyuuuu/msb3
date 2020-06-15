package com.bjmashibing.shiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan(basePackages = {"com.bjmashibing.shiro.moduler.mapper"})
//开启AopContext.currentProxy()增强
@EnableAspectJAutoProxy(exposeProxy=true)
//开启springboot  jdk动态代理方法
//@SpringBootApplication(exclude = { AopAutoConfiguration.class})
//@EnableTransactionManagement
@SpringBootApplication
public class ProxyApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(ProxyApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ProxyApplication.class);
    }
}