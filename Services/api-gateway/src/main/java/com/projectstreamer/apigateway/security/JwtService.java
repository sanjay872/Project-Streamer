package com.projectstreamer.apigateway.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtService {

    private final static String SECRET_KEY="214125442A472D4B6150645367566B59703373367638792F423F4528482B4D62";

    public <T> T extractClaim(String token,
                              Function<Claims,T> claimsResolver){
        final Claims claims=extractAllClaims(token); // get the Claims
        return claimsResolver.apply(claims); // get the subject, which is email
    }


    public void isTokenValid(String token){
            Jwts.parserBuilder().setSigningKey(getSignInKey()).build().parseClaimsJws(token);
    }

    public boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token){
        return extractClaim(token,Claims::getExpiration);
    }

    private Claims extractAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey()) // set the key used for signing the token
                .build() // create the builder
                .parseClaimsJws(token) // parse the token
                .getBody(); //get the claims
    }

    private Key getSignInKey(){ //
        byte[] keyBytes= Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
