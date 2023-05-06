package com.streamer.authservice;

import com.streamer.authservice.utils.PreLoadData;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(info = @Info(title = "Auth Service", version="1.0.0"))
@SecurityScheme(name = "BearerJWT",type = SecuritySchemeType.HTTP, scheme = "Bearer",bearerFormat = "JWT",
description = "Bearer token")
public class AuthServiceApplication implements CommandLineRunner{

	@Autowired
	private PreLoadData preLoadData;

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(args);
		preLoadData.loadRequiredData();
	}
}
