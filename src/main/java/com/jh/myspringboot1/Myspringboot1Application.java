package com.jh.myspringboot1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@MapperScan(value = "com.jh.myspringboot1.dao")

public class Myspringboot1Application {

    public static void main(String[] args) {
        SpringApplication.run(Myspringboot1Application.class, args);
    }

}
