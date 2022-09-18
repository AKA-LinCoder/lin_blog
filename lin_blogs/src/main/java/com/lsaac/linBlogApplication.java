package com.lsaac;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lsaac.mapper")
public class linBlogApplication {
    public static void main(String[] args) {
         SpringApplication.run(linBlogApplication.class,args);
    }
}
