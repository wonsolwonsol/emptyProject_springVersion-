package com.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dto.Goods;
import com.service.GoodsService;

@Controller
public class GoodsController {	
	@Autowired
	GoodsService service ;
	
	
	//goodsRetrieve
	@RequestMapping("/goodsList")
	public ModelAndView goodsRetrieve(@RequestParam String goods_Code, ModelAndView mav) {
			
		return mav;
	}
	
	
	//goodsAll
	@RequestMapping("/goodsAll") 
	public List<Goods> goodsAll() {
		System.out.println("goodsAll-controller=====");
		
		List<Goods> list = service.goodsAll(); 
				
	return list; 
}
	
		
	@RequestMapping("/goodsList")
	public ModelAndView goodsList(@RequestParam String goods_Category, ModelAndView mav) {
		List<Goods> list = service.goodsList(goods_Category); 
		
		List<String> color = new ArrayList<String>();
		List<String> brand = new ArrayList<String>();
		
		color = service.colorChart(goods_Category);
		brand = service.brandChart(goods_Category);
				
		mav.addObject("goodslist", list);
		mav.addObject("colorChart", color);
		mav.addObject("brandChart", brand);
		mav.addObject("category", goods_Category);
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
			
			mav.addObject("goodsList",list);
		}else if(color == null && brand !=null) {
			blist = Arrays.asList(brand);
			map.put("brand", blist);
			list = service.goodsSortBrand(map);
			
			mav.addObject("goodsList",list);
		}else if(color != null && brand !=null) {
			clist = Arrays.asList(color);
			blist = Arrays.asList(brand);
			
			map.put("color", clist);
			map.put("brand", blist);
			list = service.goodsSortBrandColor(map);
			
			mav.addObject("goodsList",list);
		}
		mav.setViewName("goodsList"); //이거 왜 jsp view로 안가지
		System.out.println(mav.toString());
		return mav;
	}
}
