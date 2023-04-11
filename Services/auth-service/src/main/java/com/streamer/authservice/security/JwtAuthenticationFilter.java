package com.streamer.authservice.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
            @NotNull HttpServletRequest request,
            @NotNull HttpServletResponse response,
            @NotNull FilterChain filterChain)
            throws ServletException, IOException {
        final String authHeader=request.getHeader("Authorization"); // get the token
        final String jwt;
        final String userEmail;
        if(authHeader==null || !authHeader.startsWith("Bearer")){ // check if token not exist
            filterChain.doFilter(request,response); //moving to other filters
            return; //exist as the token is not valid
        }
        jwt=authHeader.substring(7); //the real token starts after 7 characters
        userEmail=jwtService.extractUserEmail(jwt); // get email from the token
        if(userEmail!=null){ // check if user email exist
            if(SecurityContextHolder.getContext().getAuthentication()==null){ //not authenticated yet
                UserDetails userDetails=this.userDetailsService.loadUserByUsername(userEmail);
                if(jwtService.isTokenValid(jwt,userDetails)){
                    UsernamePasswordAuthenticationToken authToken= new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()
                    ); // UserNamePasswordAuthenticationToken is needed by spring boot to create the context for new user
                    authToken.setDetails( // it takes an object
                            new WebAuthenticationDetailsSource().buildDetails(request) // passing the request details
                    ); // passing additional details in the token
                    SecurityContextHolder.getContext().setAuthentication(authToken); // updating the context with new user
                }
            }
        }
        filterChain.doFilter(request,response);
        return;
    }
}
