package com.praveen.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
	
	@GetMapping("/message")
	public String printMessage() {
		return "Spring Boot with K8s";
	}

}
