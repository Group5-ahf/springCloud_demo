package com.jk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy//声明是一个路由转发zuul
@EnableEurekaClient
public class TestZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestZuulApplication.class, args);
	}
}
