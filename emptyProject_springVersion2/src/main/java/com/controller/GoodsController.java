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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dto.Goods;
import com.dto.Page;
import com.service.GoodsService;

@Controller
public class GoodsController {	
	@Autowired
	GoodsService service ;	
	
	//goodsRetrieve
	@RequestMapping("/goodsRetrieve")
	public ModelAndView goodsRetrieve(@RequestParam String goods_Code, 
										ModelAndView mav) {
		Goods good = service.goodsRetrieve(goods_Code);
		//ModelAndView mav = new ModelAndView(); 
		mav.setViewName("goodsRetrieve");
		mav.addObject("goodsRetrieve", good); 
		return mav;
	}
		
	//goodsAll
	@RequestMapping("/goodsAll") 
	public String goodsAllPaging(HttpSession session, Model mod, @RequestParam(required=false) int currentPage) {		
		//color chart, brand chart
		List<String> color = new ArrayList<String>();
		List<String> brand = new ArrayList<String>();
		Page page = null;
		
		color = service.colorChartAll();
		brand = service.brandChartAll();
				
		session.setAttribute("colorChart", color);
		session.setAttribute("brandChart", brand);		
				
		
		if(currentPage == 0){
			currentPage = 1;
		}
		page = service.goodsAllPage(currentPage);			
		
		System.out.println("pagelist:     "+page);
		mod.addAttribute("page", page);	
	return "goodsAll"; 
}
	
	@RequestMapping("/goodsSearch")
	public String goodsSearch(@RequestParam String search, Model mod, HttpSession session) {
		List<String> color = service.colorChartAll();
		List<String> brand = service.brandChartAll();
				
		session.setAttribute("colorChart", color);
		session.setAttribute("brandChart", brand);		
		
		Page list = service.goodsSearch(search);
		mod.addAttribute("page", list);
		return "goodsAll"; 		
	}
		
//	//goodsAll
//		@RequestMapping("/goodsAll") 
//		public String goodsAll(HttpSession session, Model mod) {		
//			//color chart, brand chart
//			List<String> color = new ArrayList<String>();
//			List<String> brand = new ArrayList<String>();
//			
//			color = service.colorChartAll();
//			brand = service.brandChartAll();
//					
//			session.setAttribute("colorChart", color);
//			session.setAttribute("brandChart", brand);		
//			
//			List<Goods> list = service.goodsAll(); 
//			mod.addAttribute("goodslist",list);	
//		return "goodsAll"; 
//	}
		
	@RequestMapping("/goodslist")
	public ModelAndView goodsList(@RequestParam String goods_Category, ModelAndView mav, HttpSession session, @RequestParam int currentPage) {
		System.out.println(goods_Category); 
		//이전의 저장되어 있던 카테고리를 지워줌 
		session.removeAttribute("category");
		//지금 필요한 카테고리 값은 쿼리스트링으로 받아옴
		if(currentPage == 0){
			currentPage = 1;
		}
		
		Page list = service.goodsList(goods_Category, currentPage); 
		List<String> color = new ArrayList<String>();
		List<String> brand = new ArrayList<String>();
		
		color = service.colorChart(goods_Category);
		brand = service.brandChart(goods_Category);
				
		session.setAttribute("colorChart", color);
		session.setAttribute("brandChart", brand);
		session.setAttribute("category", goods_Category);
				
		mav.addObject("page", list);
		mav.setViewName("goodsList");		
		System.out.println(list);
		return mav;
	}
	
	@RequestMapping("/goodsSortColorBrand")
	public ModelAndView goodsSortColorBrand(
			@RequestParam String category, @RequestParam(required=false) String [] color, 
			@RequestParam(required=false) String [] brand, ModelAndView mav) {
				
		HashMap<String, Object> map = new HashMap<>();
		Page list = null;
		List<String> clist = null;
		List<String> blist = null;
		
		map.put("category", category);
		mav.addObject("category",category);
		
		if(color != null && brand ==null) {
			clist = Arrays.asList(color);
			map.put("color", clist);
			list = service.goodsSortColor(map);
			
			mav.addObject("page",list);
		}else if(color == null && brand !=null) {
			blist = Arrays.asList(brand);
			map.put("brand", blist);
			list = service.goodsSortBrand(map);
			
			mav.addObject("page",list);
		}else if(color != null && brand !=null) {
			clist = Arrays.asList(color);
			blist = Arrays.asList(brand);
			
			map.put("color", clist);
			map.put("brand", blist);
			list = service.goodsSortBrandColor(map);
			
			mav.addObject("page",list);
		}
		System.out.println("sortList "+list.getList());
		mav.setViewName("goodsList");
		return mav;
	}
	
	@RequestMapping("/goodsSortPrice")
	public ModelAndView goodsSortPrice(@RequestParam String category, @RequestParam String sortSelect, ModelAndView mav) {
//		sort 결과를 page로 리턴하려면 다른 view가 필요하므로 생략
//		if(currentPage == 0){
//			currentPage = 1;
//		}
		Page list = null;
		if(sortSelect.equals("가격역순")) {
			list = service.goodsSortHigh(category);	
			mav.addObject("page",list);
		}else if(sortSelect.equals("가격순")) {
			list = service.goodsSortLow(category);
			mav.addObject("page",list);
		}		
		mav.setViewName("goodsList");
		return mav;
	}
	
	@RequestMapping("/goodsSortColorBrandAll")
	public ModelAndView goodsSortColorBrandAll(
			@RequestParam(required=false) String [] color, 
			@RequestParam(required=false) String [] brand, ModelAndView mav) {
				
		HashMap<String, Object> map = new HashMap<>();
		Page list = null;
		List<String> clist = null;
		List<String> blist = null;		
		
		if(color != null && brand ==null) {
			clist = Arrays.asList(color);
			map.put("color", clist);
			list = service.goodsSortColorAll(map);
			
			mav.addObject("page",list);
		}else if(color == null && brand !=null) {
			blist = Arrays.asList(brand);
			map.put("brand", blist);
			list = service.goodsSortBrandAll(map);
			
			mav.addObject("page",list);
		}else if(color != null && brand !=null) {
			clist = Arrays.asList(color);
			blist = Arrays.asList(brand);
			
			map.put("color", clist);
			map.put("brand", blist);
			list = service.goodsSortBrandColorAll(map);
			
			mav.addObject("page",list);
		}
		mav.setViewName("goodsAll");
		return mav;
	}
	
	@RequestMapping("/goodsSortPriceAll")
	public ModelAndView goodsSortPriceAll(@RequestParam String sortSelect, ModelAndView mav) {
		
		Page list = null;
		
		if(sortSelect.equals("가격역순")) {
			System.out.println("가격역순");
			list = service.goodsSortHighAll();	
			mav.addObject("page",list);
		}else if(sortSelect.equals("가격순")) {
			System.out.println("가격순");
			list = service.goodsSortLowAll();
			mav.addObject("page",list);
		}		
		mav.setViewName("goodsAll");
		return mav;
	}
}
