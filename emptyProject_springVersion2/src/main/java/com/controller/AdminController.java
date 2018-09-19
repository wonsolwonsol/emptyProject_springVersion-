package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dto.Goods;
import com.service.AdminService;

@Controller
public class AdminController {
	@Autowired
	AdminService service;
	
	@RequestMapping("/adminCheck/adminGoods")
	public String adminGoods(Model mod) {
		List<Goods> list = service.goodsAll();
		
		mod.addAttribute("goodslist",list);
		return "adminPage";
	}
}
