package com.projectstreamer.apigateway.filter;

import com.projectstreamer.apigateway.security.JwtService;
import org.apache.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    @Autowired
    private RouteValidator routeValidator;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JwtService jwtService;

    private String tokenValidateUrl="http://auth-service/api/v1/auth/validate";

    public AuthenticationFilter(){
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (((exchange, chain) -> {
            if(routeValidator.isSecured.test(exchange.getRequest())){
                if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)){
                    throw new RuntimeException("Authorization Header required!");
                }
            }
            String authHeader= exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
            if(authHeader!=null && authHeader.startsWith("Bearer ")){
                String token=authHeader.substring(7);
                try{
//                    restTemplate.getForEntity(tokenValidateUrl+"?token="+token,String.class);
                    jwtService.isTokenValid(token);
                }
                catch (Exception e){
                    throw new RuntimeException("Token Invalid!");
                }
            }
            else{
                throw new RuntimeException("Invalid Token Format");
            }
            return chain.filter(exchange);
        }));
    }

    public static class Config{

    }

}
