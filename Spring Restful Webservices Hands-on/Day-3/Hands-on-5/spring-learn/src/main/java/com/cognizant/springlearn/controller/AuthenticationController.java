package com.cognizant.springlearn.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AuthenticationController {

	@GetMapping("/authenticate")
	public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
		log.info("START");
		
		String user = getUser(authHeader);
		String token = generateJwt(user);
		
		Map<String, String> authMap = new HashMap<>();
		authMap.put("token", token);
		
		log.info("END");
		return authMap;
	}

	private String getUser(String authHeader) {
		log.info("START");
		
		String encodedCredentials = authHeader.substring(6);
		byte[] decodedCredentials = Base64.getDecoder().decode(encodedCredentials);
		String user = new String(decodedCredentials).split(":")[0];
		
		log.info("END");
		return user;
	}

	private String generateJwt(String user) {
		log.info("START");
		JwtBuilder builder = Jwts.builder();
		builder.setSubject(user);

		// Set the token issue time as current time
		builder.setIssuedAt(new Date());

		// Set the token expiry as 20 minutes from now
		builder.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(20)));
		builder.signWith(SignatureAlgorithm.HS256, "secretkey");
		String token = builder.compact();
		log.info("END");
		return token;
	}
}
