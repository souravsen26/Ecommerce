package com.ecommerce.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class EcommerceServiceDashApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceServiceDashApplication.class, args);
	}

}
