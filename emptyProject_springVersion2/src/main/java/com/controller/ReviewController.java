package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReviewController {

	@RequestMapping("/review")
	public String review() {
		return "review"; 
	}
	
	@RequestMapping("/reviewRetrieve")
	public String reviewRetrieve() {
		return "home"; 
	}
}
