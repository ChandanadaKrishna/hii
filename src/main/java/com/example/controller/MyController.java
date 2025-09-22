package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class MyController {
    
	@GetMapping("/redish")
	@CircuitBreaker(fallbackMethod = "getDatabase",name = "krihsna")
	public String getRedish() {
		System.out.println("redish() executed");
		int a=10/0;
		return "redish() method";
	}
	
	public String getDatabase(Throwable t) {
		System.out.println("database() executed");
		return "database() method";
	}
}
