package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dto.Goods;
import com.dto.Page;
import com.service.AdminService;
import com.service.GoodsService;

@Controller
public class AdminController {
	@Autowired
	AdminService service;
	
	@Autowired
	GoodsService goodsService;
	
	/*
	 * 이하 react cross origin	
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
	*/
	
	@RequestMapping(value="/adminCheck/adminGoods", method=RequestMethod.GET)
	public String adminGoods(@RequestParam int currentPage, HttpSession session) {
		Page list = goodsService.goodsAllPage(currentPage);		
		session.setAttribute("page",list);
		return "redirect:../adminPage";
	}
	
	@RequestMapping(value="/adminCheck/adminGoodsAdd", method=RequestMethod.POST)
	public String insert(@RequestParam Goods goods) {
		
		
		
		service.adminGoodsAdd(goods);
		return "redirect:../adminPage";
	}
	
	@RequestMapping(value="/adminCheck/adminGoodsUpdate", method=RequestMethod.PUT)
	public String update(@RequestParam Goods goods) {
		service.adminGoodsUpdate(goods);
		return "redirect:../adminPage";
	}
	
	@RequestMapping(value="/adminCheck/adminGoodsDelete/{goods_Code}", method=RequestMethod.DELETE)
	public String delete(@PathVariable String goods_Code) {
		service.adminGoodsDelete(goods_Code);
		return "redirect:../adminPage";
	}
	
}
