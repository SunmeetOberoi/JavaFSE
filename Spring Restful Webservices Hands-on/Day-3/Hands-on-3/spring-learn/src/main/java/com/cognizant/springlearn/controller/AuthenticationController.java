package com.cognizant.springlearn.controller;

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
		Map<String, String> authMap = new HashMap<>();
		authMap.put("token", "");
		log.info("END");
		return authMap;
	}
}
