package com.xyz.bususer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BusUserServiceApplication {

	public static void main(String[] args) {
		System.out.println("Bus User service Starts here ...");
		SpringApplication.run(BusUserServiceApplication.class, args);
	}

}
