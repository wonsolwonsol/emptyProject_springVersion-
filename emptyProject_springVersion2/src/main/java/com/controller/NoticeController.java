package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.Notice;
import com.service.NoticeService;
import com.dto.Page;

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
/*	@RequestMapping("/notice")
	public ModelAndView noticeAll(){
		List<Notice> list = service.noticeAll(); 
			ModelAndView m = new ModelAndView();
		
			m.addObject("Notice", list ); 
			m.setViewName("notice");

		return m ; 
	}*/
	
	@RequestMapping("/notice2")
	public String notice(HttpSession session, Model mod, @RequestParam int currentPage) {
		
		if(currentPage == 0){
			currentPage = 1;
		}
		Page page = service.noticeAll2(currentPage); 
		System.out.println("pagelist:     "+page);
		mod.addAttribute("page", page);	
	return "notice"; 
	}
	
}
