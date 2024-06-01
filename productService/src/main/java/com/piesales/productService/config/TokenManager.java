package com.piesales.productService.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.piesales.productService.services.impl.AuthTokenService;

@Configuration
public class TokenManager {

    private String token;
    @Autowired
    private AuthTokenService authTokenService;

    public synchronized String getToken() {
        if (token == null ) {
            refreshToken();
        }
        return token;
    }

    private void refreshToken() {
        System.out.println("I am not coming here");
        token = authTokenService.getAuthToken("parmarharsh123456@gmail.com", "password"); // Replace with actual credentials or method to fetch them securely
    }

}