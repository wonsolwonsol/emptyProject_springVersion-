package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dto.Notice;
import com.service.NoticeService;

@Controller
public class NoticeController {

	@Autowired
	NoticeService service;
	
	//공지 쓰기 
	@RequestMapping("/noticeWrite")
	public String noticeWrite(){
		System.out.println("noticeWriteController======");
		
		return "noticeWrite" ; 
	}
	
	
	
	//questionBoard, NoticeBoard, ReviewBoard 
	//관리자용 쓰기, 전체회원 읽기, 내용분리 
	@RequestMapping("/notice")
	public ModelAndView noticeAll(){
		List<Notice> list = service.noticeAll(); 
			ModelAndView m = new ModelAndView();
		
			m.addObject("Notice", list ); 
			m.setViewName("notice");

		return m ; 
	}
	
}
