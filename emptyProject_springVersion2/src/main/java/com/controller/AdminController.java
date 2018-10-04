package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dto.Goods;
import com.service.AdminService;
import com.service.GoodsService;

@Controller
public class AdminController {
	@Autowired
	AdminService service;
	
	@Autowired
	GoodsService goodsService;
	
	@RequestMapping(value="/adminGoods", method=RequestMethod.GET)
	@CrossOrigin
	public @ResponseBody List<Goods> adminGoods() {
		List<Goods> list = goodsService.goodsAll();			
		return list;
	}
	
	@RequestMapping(value="/adminGoodsAdd", method=RequestMethod.POST)
	@CrossOrigin
	public @ResponseBody void insert(@RequestBody Goods goods) {
		System.out.println("goods "+goods);
		service.adminGoodsAdd(goods);
	}
	
	@RequestMapping(value="/adminGoodsUpdate", method=RequestMethod.PUT)
	@CrossOrigin
	public @ResponseBody void update(@RequestBody Goods goods) {
		service.adminGoodsUpdate(goods);
	}
	
	@RequestMapping(value="/adminGoodsDelete/{goods_Code}", method=RequestMethod.DELETE)
	@CrossOrigin
	public @ResponseBody void delete(@PathVariable String goods_Code) {
		service.adminGoodsDelete(goods_Code);
	}
	
	
}
