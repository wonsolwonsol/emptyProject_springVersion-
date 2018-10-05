package com.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dto.PagingVO;
import com.dto.Question;
import com.service.QuestionBoardService;

import ch.qos.logback.classic.Logger;

@Controller
public class QuestionController {

	@Autowired
	QuestionBoardService service; 
	
		@RequestMapping(value="/question", method=RequestMethod.GET) 
		public String question(String m) {
			//Logger.info("paging :     "+p); //플러그인 필요, 로그
		
	
			
			
			return "question"; 
		}
		
		
		@RequestMapping("/questionWrite")
		public String questionWrite() {
			
			return "questionWrite"; 
			
		}
		
		@RequestMapping("/questionUpdate")
		public String questionUpdate() {
			
			return null; 
		}
}
