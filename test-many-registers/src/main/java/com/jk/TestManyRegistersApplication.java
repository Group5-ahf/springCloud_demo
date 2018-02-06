package com.jk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer//声明是注册中心的注解
public class TestManyRegistersApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestManyRegistersApplication.class, args);
	}
}
