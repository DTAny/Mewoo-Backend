package com.github.dtanything.mewoobackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.github.dtanything.mewoobackend.mapper")
public class MewooBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(MewooBackendApplication.class, args);
    }

}
