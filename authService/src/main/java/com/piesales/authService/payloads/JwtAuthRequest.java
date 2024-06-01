package com.piesales.authService.payloads;

import lombok.Data;

@Data
public class JwtAuthRequest {

	private String email;
	
	private String password;
	
}
