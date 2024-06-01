package com.piesales.orderService.payloads;


import lombok.Data;

@Data
public class JwtAuthRequest {
    public JwtAuthRequest(String email, String password){
        this.email = email;
        this.password = password;
    }

	private String email;
	private String password;
	
}