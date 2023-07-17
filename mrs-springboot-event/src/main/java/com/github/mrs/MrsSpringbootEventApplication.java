package com.github.mrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class MrsSpringbootEventApplication {

    public static void main(String[] args) {
        SpringApplication.run(MrsSpringbootEventApplication.class, args);
    }

}
