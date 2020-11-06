package com.zjrc.sm2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@MapperScan("com.zjrc.sm2.dao")
@EnableTransactionManagement
public class Sm2Application {

    public static void main(String[] args) {
        SpringApplication.run(Sm2Application.class, args);
    }

}
