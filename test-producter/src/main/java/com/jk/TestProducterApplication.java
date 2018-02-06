package com.jk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient//该注解声明是生产者。
public class TestProducterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestProducterApplication.class, args);
	}
}
