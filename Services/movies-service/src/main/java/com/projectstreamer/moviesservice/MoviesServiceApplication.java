package com.projectstreamer.moviesservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
//@OpenAPIDefinition(info = @Info(title = "Movie Service", version="1.0.0"))
//@SecurityScheme(name = "BearerJWT",type = SecuritySchemeType.HTTP, scheme = "Bearer",bearerFormat = "JWT",
//		description = "Bearer token")
public class MoviesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesServiceApplication.class, args);
	}

}
