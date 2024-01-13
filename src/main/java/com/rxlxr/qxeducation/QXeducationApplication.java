package com.rxlxr.qxeducation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.rxlxr.qxeducation.Mapper")
@SpringBootApplication
public class QXeducationApplication {

    public static void main(String[] args) {
        SpringApplication.run(QXeducationApplication.class, args);
    }

}
