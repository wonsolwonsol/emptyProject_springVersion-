package com.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.Page3;
import com.dto.Review;
import com.dto.ReviewJoin;
import com.service.ReviewBoardService;

@Controller
public class ReviewController {

	@Autowired
	ReviewBoardService service; 
	
	@RequestMapping("/review")
	public String review(@RequestParam int currentPage, Model m) {
		if(currentPage == 0) {
			currentPage = 1 ; 
		}
		Page3 page = service.review(currentPage);
		List<Review> mod = page.getList();
		m.addAttribute("page", page);
		return "review"; }

	//@RequestParam String review_number ==> 임시고정 
	@RequestMapping("/reviewRetrieve")
	public ModelAndView reviewRetrieve(@RequestParam String review_number, ModelAndView m) {
		System.out.println("review Controller >>>>>>>>>>>>>>>>>>");
			List<ReviewJoin> rj = service.reviewRetrieveJoin(review_number);
			m.addObject("reviewRetrieve", rj);
			m.setViewName("reviewRetrieve");

		return m; 
	}
	
	
	@RequestMapping("/reviewDelete")
	public String reviewDelete(@RequestParam String review_number) {
		return null ; 
	}
	
	@RequestMapping("/reviewUpdate")
	public String reviewUpdate(@RequestParam String review_number) {
		return null ; 
	}
	@RequestMapping("/reviewWrite")
	public String reviewWrite(@RequestParam String review_number) {
		return null ; 
	}
	
	
	
	
}
