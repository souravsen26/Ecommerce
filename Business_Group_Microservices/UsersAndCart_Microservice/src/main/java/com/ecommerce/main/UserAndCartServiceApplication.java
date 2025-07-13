package com.ecommerce.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserAndCartServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserAndCartServiceApplication.class, args);
	}

}
