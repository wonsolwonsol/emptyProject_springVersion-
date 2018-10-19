package com.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.Review;
import com.dto.ReviewJoin;
import com.service.ReviewBoardService;

@Controller
public class ReviewController {

	@Autowired
	ReviewBoardService service; 
	
	@RequestMapping("/review")
	public String review() {
		return "review"; 
	}

	
	//@RequestParam String review_number ==> 임시고정 
	@RequestMapping("/reviewRetrieve")
	public ModelAndView reviewRetrieve(@RequestParam String review_number, ModelAndView m) {
		System.out.println("review Controller >>>>>>>>>>>>>>>>>>");
			List<ReviewJoin> rj = service.reviewRetrieveJoin(review_number);
			m.addObject("reviewRetrieve", rj);
			m.setViewName("reviewRetrieve");

		return m; 
	}
	
	
}
