package com.adiops.loyality.app.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web") 
public class WebApplicationController {

	@GetMapping("/home")
	public String home1(Model model) {
		return "home";
	}

	
}
