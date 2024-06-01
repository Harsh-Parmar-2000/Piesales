package com.piesales.cartService.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.piesales.cartService.payloads.JwtAuthRequest;
import com.piesales.cartService.payloads.JwtAuthResponse;


@Service
public class AuthTokenService {
    @Autowired
    private RestTemplate restTemplate;

    public String getAuthToken(String email, String password) {
        String url = "http://localhost:9091/auth/api/login";

        JwtAuthRequest request = new JwtAuthRequest(email, password);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<JwtAuthRequest> entity = new HttpEntity<>(request, headers);
        ResponseEntity<JwtAuthResponse> response = restTemplate.exchange(url, HttpMethod.POST, entity, JwtAuthResponse.class);
        return response.getBody().getToken();
    }
    
}