package com.revature.areaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@EnableEurekaClient
@OpenAPIDefinition
public class AreaserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AreaserviceApplication.class, args);
	}

}
