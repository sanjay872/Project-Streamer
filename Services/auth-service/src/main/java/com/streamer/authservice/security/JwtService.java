package com.streamer.authservice.security;

import com.streamer.authservice.exception.exceptions.CustomException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private final static String SECRET_KEY="214125442A472D4B6150645367566B59703373367638792F423F4528482B4D62";

    public String extractUserEmail(String token) {
        return extractClaim(token,Claims::getSubject);
    }

    public <T> T extractClaim(String token,
                              Function<Claims,T> claimsResolver){
        final Claims claims=extractAllClaims(token); // get the Claims
        return claimsResolver.apply(claims); // get the subject, which is email
    }

    public String generateToken(UserDetails userDetails){ // generate token only with userDetails
        Map<String,Object> extraClaims=new HashMap<>();
        extraClaims.put("roles",userDetails.getAuthorities());
        return generateToken(extraClaims,userDetails);
    }

    public String generateToken(Map<String,Object> extraClaims,
                                UserDetails userDetails){ // generate token with roles and userDetails
        return Jwts
                .builder()
                .setClaims(extraClaims) // set roles and authorities
                .setSubject(userDetails.getUsername()) // set email
                .setIssuedAt(new Date(System.currentTimeMillis())) // created date
                .setExpiration(new Date(System.currentTimeMillis() + (1000 * 60 * 60))) // expiration time 1 hr
                .signWith(getSignInKey(), SignatureAlgorithm.HS256) // sign key and algorithm
                .compact(); // generate and return the token
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        final String userName=extractUserEmail(token);
        return  !isTokenExpired(token) && userName.equals(userDetails.getUsername());
    }

    private boolean isTokenExpired(String token){
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
