package com.piesales.productService.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.piesales.productService.payloads.JwtAuthRequest;

@Service
public class AuthTokenService {
    @Autowired
    private RestTemplate restTemplate;

    public String getAuthToken(String email, String password) {
        System.out.println("Yes I am calling");
        System.out.println("Yes I am calling");
        String url = "http://AUTHSERVICE/auth/api/login";
        JwtAuthRequest request = new JwtAuthRequest(email, password);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<JwtAuthRequest> entity = new HttpEntity<>(request, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        System.out.println("Yes Still I am calling");
        return response.getBody();
    }
    
}