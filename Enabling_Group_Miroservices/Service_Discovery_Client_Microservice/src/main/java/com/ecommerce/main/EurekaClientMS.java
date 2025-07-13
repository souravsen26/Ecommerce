package com.ecommerce.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaClientMS {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientMS.class, args);
	}

}
