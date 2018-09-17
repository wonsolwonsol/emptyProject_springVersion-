package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.Goods;
import com.service.GoodsService;

@Controller
public class GoodsController {	
	@Autowired
	GoodsService service ;
		
	@RequestMapping("/GoodsList")
	public String GoodsList() {
		List<Goods> list = service.GoodsList(); 
		
		
		
		return "GoodsList";
	}
}
