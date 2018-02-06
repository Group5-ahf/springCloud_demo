package com.jk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableDiscoveryClient//消费者向服务中心注册的注解
@EnableHystrix//开启断路器的注解
@EnableHystrixDashboard//开启断路器监控的注解
public class TestRibbonConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestRibbonConsumerApplication.class, args);
	}

	@Bean//将RestTemplate注入spring
	@LoadBalanced//ribbon开启负载均衡，默认轮询
	RestTemplate restTemplate() {

		return new RestTemplate();

	}
}
