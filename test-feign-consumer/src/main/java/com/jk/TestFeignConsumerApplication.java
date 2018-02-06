package com.jk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableDiscoveryClient//消费者向服务中心注册的注解
@EnableFeignClients//声明是Feign类型的消费者。
@EnableHystrix//开启断路器的注解。
@EnableHystrixDashboard//开启断路器监控器的注解。
public class TestFeignConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestFeignConsumerApplication.class, args);
	}
}
