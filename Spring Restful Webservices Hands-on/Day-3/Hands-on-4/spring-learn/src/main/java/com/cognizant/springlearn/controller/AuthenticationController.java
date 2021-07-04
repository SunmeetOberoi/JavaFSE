package com.cognizant.springlearn.controller;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AuthenticationController {

	
	@GetMapping("/authenticate")
	public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader){
		log.info("START");
		log.debug("authHeader: {}", authHeader);
		String user = getUser(authHeader);
		log.debug("User: {}", user);
		Map<String, String> authMap = new HashMap<>();
		authMap.put("token", "");
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
}
