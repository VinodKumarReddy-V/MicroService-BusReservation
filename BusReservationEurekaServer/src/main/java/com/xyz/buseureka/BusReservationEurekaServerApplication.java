package com.xyz.buseureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class BusReservationEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusReservationEurekaServerApplication.class, args);
	}

}
