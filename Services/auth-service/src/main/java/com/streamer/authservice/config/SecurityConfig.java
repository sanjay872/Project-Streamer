package com.streamer.authservice.config;

import com.streamer.authservice.security.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationFilter jwtAuthFilter;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    private final static String[] WHITELIST={
            "/api/v1/auth/**", //AUTH
            //SWAGGER-----------
            "/v3/api-docs/**","/swagger-ui/**"
            ,"/auth-service/v3/api-docs/**","/auth-service/swagger-ui/**","/auth-service/swagger-ui.html"
            //------------------
    };

    private final static String[] ADMIN_ENDPOINTS={
            "/api/v1/role/**",
            "/api/v1/authority/**",
            "/api/v1/admin/**"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests()
                .requestMatchers(WHITELIST)
                .permitAll()
                .requestMatchers(ADMIN_ENDPOINTS).hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) //because each request need to be authenticated
                .and()
                .authenticationProvider(authenticationProvider) // give authentication provider
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class); // to make sure jwt filter get executed before userNamePasswordAuthentication
        return http.build();
    }
}
