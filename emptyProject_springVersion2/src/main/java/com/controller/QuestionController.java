package com.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.Page2;
import com.dto.Question;
import com.dto.Question_Comments;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.service.QuestionBoardService;
import com.service.QuestionCommentService;

import ch.qos.logback.classic.Logger;

@Controller
public class QuestionController {

	@Autowired
	QuestionBoardService service; 
	@Autowired
	QuestionCommentService qservice; 
	
		@RequestMapping(value="/questionCommentDelete")
		public String questionCommentDelete(@RequestParam int comment_number, @RequestParam int question_number) {
			System.out.println("Controller : question_num====="+question_number);
			System.out.println("Controller : comment_number======="+comment_number);
			qservice.questionCommentDelete(comment_number); 
			//return "redirect:/question?currentPage=1"; 
			return "redirect:/questionRetrieve?question_number="+question_number; 
		}
		@RequestMapping("/questionDelete")
		public String questionDelete(@RequestParam int question_number){
			System.out.println("=======questionDelete Controll>>>>"+question_number);
			service.questionDelete(question_number); 
			return "redirect:/question?currentPage=1"; 
		}
		@RequestMapping(value="/question") 
		public String question(HttpSession session, Model mod, @RequestParam int currentPage) {
			//Logger.info("paging :     "+p); //플러그인 필요, 로그
			if(currentPage == 0){
				currentPage = 1;}
			Page2 page = service.questionAll(currentPage); 
			System.out.println("pagelist:     "+page);
			System.out.println("QuestionControll===============");
			List<Question> m = page.getList();
			System.out.println(m);
			mod.addAttribute("page", page);	
			System.out.println("dsada"+m);
			return "question"; }
		
		@RequestMapping("/questionWrite")
		public String questionWrite() {
			return "questionWrite";}
		@RequestMapping(value="/questionWriteSumit", method=RequestMethod.POST) 
		public String questionWriteSumit(Question question){
			System.out.println("===================questionWriteSumit>>>>>>>>>");

			System.out.println(question); 
			service.questionWriteSubmit(question);
			return "redirect:/question?currentPage=1" ; 
		}
		@RequestMapping("/questionRetrieve")
		public ModelAndView questionRetrieve(@RequestParam String question_number
				, ModelAndView m) {
			Question q = service.questionRetrieve(question_number); 
			
			 
			//questionComment 
			List<Question_Comments> qc = qservice.Question_Comments(question_number); 
			
			m.addObject("questionRetrieve", q);
			m.setViewName("questionRetrieve");
			m.addObject("questionComment", qc); 
			
			return m; 
		}
		
/*		@RequestMapping("/questionDelete")
		public String questionDelete() {
			return "redirect:question"; 
		}
	*/
		//questionCommentWrite
		@RequestMapping("/questionCommentWrite")
		public String questionCommentWrite() {
			return "question?currentPage=1"; 
		}
		//questionUpdate
		@RequestMapping("/questionUpdateUI")
		public ModelAndView questionUpdateUI(@RequestParam String question_number, ModelAndView m, Question question) {
			System.out.println("QuestionController>>>>questionUpdate>>>>>>>>"+question_number);
			//return "redirect:/question?currentPage=1" ; 
			Question q = service.questionRetrieve(question_number); 
			System.out.println("CHECK >>>>>>>>"+q);
			m.addObject("questionUpdateUI", q);
			m.setViewName("questionUpdateUI");
			return m; 
		}
		@RequestMapping("/questionUpdate")
		public String questionUpdate(Question q) {
			System.out.println("contoller>>>>>>update>>>>>>");
			System.out.println(">>>>>>>>>>>>>>>>>>>"+q);
			service.questionUpdate(q); 
			return "redirect:/question?currentPage=1"; 
		}
	
}
