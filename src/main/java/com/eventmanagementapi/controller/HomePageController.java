package com.eventmanagementapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomePageController {

	@GetMapping("/home")
	public String homePage() {
		return "Hello.. welcome to event management home page";
	}
}
