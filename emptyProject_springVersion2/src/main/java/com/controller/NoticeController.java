package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dto.Notice;
import com.service.CartService;
import com.service.NoticeBoardService;

@Controller
public class NoticeController {

	@Autowired
	NoticeBoardService service;
	
	//questionBoard, NoticeBoard, ReviewBoard 
	//관리자용 쓰기, 전체회원 읽기, 내용분리 
	@RequestMapping("/Notice")
	public List<Notice> NoticeList(){
		
		return null ; 
	}
	
}
