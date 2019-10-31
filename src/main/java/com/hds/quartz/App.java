package com.hds.quartz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
/**
 * @Classname App
 * @Description TODO
 * @Date 2019/10/31 21:41
 * @Created by huangdasheng
 */
@ComponentScan(basePackages = "com.hds.*")
@MapperScan(basePackages="com.hds.repository")
public class App extends SpringBootServletInitializer {


    /**
     * @Author huangds
     * @Description //TODO
     * @Date 22:00 2019/10/29
     * @Param
     * @return
     **/
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

        return builder.sources(App.class);
    }

}