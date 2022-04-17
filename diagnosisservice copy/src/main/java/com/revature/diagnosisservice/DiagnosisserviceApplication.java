package com.revature.diagnosisservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@EnableEurekaClient
@OpenAPIDefinition
public class DiagnosisserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiagnosisserviceApplication.class, args);
	}
	
//	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
