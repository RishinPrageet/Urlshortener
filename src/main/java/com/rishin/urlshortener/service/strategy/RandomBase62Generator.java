package com.rishin.urlshortener.service.strategy;

import java.security.SecureRandom;

import org.springframework.stereotype.Component;

@Component
public class RandomBase62Generator implements ShortCodeGenerator {
    
    private static final String ALPHABET =
            "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final SecureRandom RANDOM = new SecureRandom();
    @Override
    public  String generate() {
        StringBuilder sb = new StringBuilder(7);

        for (int i = 0; i < 7; i++) {
            sb.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }

        return sb.toString();
    }

}
