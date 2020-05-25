package com.bjmashibing.shiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@MapperScan(basePackages = {"com.bjmashibing.shiro.moduler.*.mapper"})
@SpringBootApplication
public class TmailApplication9007 extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(TmailApplication9007.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TmailApplication9007.class);
    }
}