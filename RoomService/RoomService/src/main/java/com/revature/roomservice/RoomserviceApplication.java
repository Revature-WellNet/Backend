package com.revature.roomservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@EnableEurekaClient
@OpenAPIDefinition
public class RoomserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomserviceApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		
		return new RestTemplate();
		
	}
	  
}
