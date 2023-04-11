package com.streamer.servicedisclosure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceDisclosureApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDisclosureApplication.class, args);
	}

}
