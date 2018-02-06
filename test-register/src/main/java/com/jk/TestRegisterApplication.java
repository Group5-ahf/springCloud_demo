package com.jk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer//该注解声明是服务注册中心
public class TestRegisterApplication {
//jkjgkfhgh
	// ghg
	public static void main(String[] args) {
		SpringApplication.run(TestRegisterApplication.class, args);
	}
}
