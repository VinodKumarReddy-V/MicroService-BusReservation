package com.xyz.busadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BusAdminServiceApplication {

	public static void main(String[] args) {
		System.out.println("Bus admin project server starts here ");
		SpringApplication.run(BusAdminServiceApplication.class, args);
	}

}
