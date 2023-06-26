package com.projectstreamer.apigateway.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouteValidator {

    public static final List<String>  openEndPoints=List.of(
            "/auth/**",
            "auth/v3/api-docs/**",
            "movies/v3/api-docs/**",
            "watchlist/v3/api-docs/**",
            "auth/swagger-ui/**",
            "movies/swagger-ui/**",
            "watchlist/swagger-ui/**",
            "/swagger-ui/**","/swagger-resources/**","/swagger-ui.html","/v2/api-docs","/webjars/**","/view/**"

    );

    public Predicate<ServerHttpRequest> isSecured=
            request -> openEndPoints.stream().noneMatch(uri ->request.getURI().getPath().contains(uri));
}