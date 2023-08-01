package com.github.mrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class MrsMulitiThreadApplication {

	public static void main(String[] args) {
		SpringApplication.run(MrsMulitiThreadApplication.class, args);
	}

}
