package com.streamer.authservice.utils;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

@Component
public class Utils {

    private final Random random=new SecureRandom();

    private final String characters="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public String generateId(int length){
        return generateRandomString(length);
    }

    private String generateRandomString(int length){
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<length;i++){
            char character=characters.charAt(random.nextInt(characters.length()));
            builder.append(character);
        }
        return builder.toString();
    }
}
