package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceExamConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceExamConsumerApplication.class, args);

	}

	@LoadBalanced
	@Bean
	public RestTemplate rt() {
		RestTemplate rs = new RestTemplate();
		return rs;

	}
}