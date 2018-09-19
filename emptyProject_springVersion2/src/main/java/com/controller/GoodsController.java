package com.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.Goods;
import com.service.GoodsService;

@Controller
public class GoodsController {	
	@Autowired
	GoodsService service ;
		
	@RequestMapping("/goodslist")
	public ModelAndView goodsList(@RequestParam String goods_Category, ModelAndView mav, HttpSession session) {
		//이전의 저장되어 있던 카테고리를 지워줌 
		session.removeAttribute("category");
		//지금 필요한 카테고리 값은 쿼리스트링으로 받아옴
		List<Goods> list = service.goodsList(goods_Category); 
		List<String> color = new ArrayList<String>();
		List<String> brand = new ArrayList<String>();
		
		color = service.colorChart(goods_Category);
		brand = service.brandChart(goods_Category);
				
		session.setAttribute("colorChart", color);
		session.setAttribute("brandChart", brand);
		session.setAttribute("category", goods_Category);
		
		mav.addObject("goodslist", list);
		mav.setViewName("goodsList");						
		return mav;
	}
	
	@RequestMapping("/goodsSortColorBrand")
	public ModelAndView goodsSortColorBrand(
			@RequestParam String category, @RequestParam(required=false) String [] color, 
			@RequestParam(required=false) String [] brand, ModelAndView mav) {
				
		HashMap<String, Object> map = new HashMap<>();
		List<String> list = null;
		List<String> clist = null;
		List<String> blist = null;
		
		map.put("category", category);
		mav.addObject("category",category);
		
		if(color != null && brand ==null) {
			clist = Arrays.asList(color);
			map.put("color", clist);
			list = service.goodsSortColor(map);
			
			mav.addObject("goodslist",list);
		}else if(color == null && brand !=null) {
			blist = Arrays.asList(brand);
			map.put("brand", blist);
			list = service.goodsSortBrand(map);
			
			mav.addObject("goodslist",list);
		}else if(color != null && brand !=null) {
			clist = Arrays.asList(color);
			blist = Arrays.asList(brand);
			
			map.put("color", clist);
			map.put("brand", blist);
			list = service.goodsSortBrandColor(map);
			
			mav.addObject("goodslist",list);
		}
		mav.setViewName("goodsList");
		return mav;
	}
	
	@RequestMapping("/goodsSortPrice")
	public ModelAndView goodsSortPrice(@RequestParam String category, @RequestParam String sortSelect, ModelAndView mav) {
		
		List<Goods> list = null;
		
		if(sortSelect.equals("가격역순")) {
			System.out.println("가격역순");
			list = service.goodsSortHigh(category);	
			mav.addObject("goodslist",list);
		}else if(sortSelect.equals("가격순")) {
			System.out.println("가격순");
			list = service.goodsSortLow(category);
			mav.addObject("goodslist",list);
		}		
		mav.setViewName("goodsList");
		return mav;
	}
}
