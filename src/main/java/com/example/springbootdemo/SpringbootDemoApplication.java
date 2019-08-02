package com.example.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})
public class SpringbootDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootDemoApplication.class, args);

        System.out.println("。。。 启动成功 。。。 ");

    }

}
