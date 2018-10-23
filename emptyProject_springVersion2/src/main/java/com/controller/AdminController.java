package com.controller;

import java.io.File;
import java.io.IOException;
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
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dto.Goods;
import com.dto.Page;
import com.dto.Upload;
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
	public String adminGoods(@RequestParam(required=false, defaultValue="1") Integer currentPage, HttpSession session) {
		if(currentPage == null || currentPage == 0 ){
			currentPage = 1;
		}
		Page list = goodsService.goodsAllPage(currentPage);		
		session.setAttribute("page",list);
		return "redirect:../adminPage";
	}
	
	@RequestMapping(value="/adminCheck/adminGoodsAdd", method=RequestMethod.POST)
	public String insert(Goods goods, Upload file) {	
		System.out.println(goods);
		System.out.println(file);

		CommonsMultipartFile[] theFile = file.getTheFile();
		
		//theFile의 두개의 파일을 인덱스 0번은 썸네일 폴더에 1번은 아이템에
		for (CommonsMultipartFile f : theFile) {
			long size = f.getSize();
			String fileName = f.getName();
			String oriFileName = f.getOriginalFilename();
			String type = f.getContentType();
			
			System.out.println("size "+size);
			System.out.println("fileName "+fileName);
			System.out.println("oriFileName "+oriFileName);
			System.out.println("type "+type);
			File loc = null;
			
			if(f == theFile[0]) {
				loc = new File("c:/upload"+"/items/thum", oriFileName);
			try {
				f.transferTo(loc);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}else if(f == theFile[1]) {
				loc = new File("c:/upload"+"/items", oriFileName);
				try {
					f.transferTo(loc);
				} catch (IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		}		
		
		service.adminGoodsAdd(goods);
		return "redirect:./adminGoods";
	}
	
	@RequestMapping(value="/adminCheck/adminGoodsUpdate", method=RequestMethod.POST)
	public String update(Goods goods, Upload file) {
		
		System.out.println(goods);
		System.out.println(file);

		CommonsMultipartFile[] theFile = file.getTheFile();
		
		//theFile의 두개의 파일을 인덱스 0번은 썸네일 폴더에 1번은 아이템에
		for (CommonsMultipartFile f : theFile) {
			long size = f.getSize();
			String fileName = f.getName();
			String oriFileName = f.getOriginalFilename();
			String type = f.getContentType();
			
			System.out.println("size "+size);
			System.out.println("fileName "+fileName);
			System.out.println("oriFileName "+oriFileName);
			System.out.println("type "+type);
			File loc = null;
			
			if(f == theFile[0]) {
			loc = new File("c:/upload"+"/items/thum", oriFileName);
			try {
				f.transferTo(loc);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}else if(f == theFile[1]) {
				loc = new File("c:/upload"+"/items", oriFileName);
				try {
					f.transferTo(loc);
				} catch (IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		}
		
		service.adminGoodsUpdate(goods);		
		return "redirect:./adminGoods";
	}
	
	@RequestMapping(value="/adminCheck/adminUpdateSelect")
	public String codeUpdate(@RequestParam String goods_Code, RedirectAttributes red) {
		Goods goods = service.adminUpdateCode(goods_Code);
		red.addFlashAttribute("goods", goods);		
		
		return "redirect:../adminUpdateGoodsPage";
	}
	
	
	@RequestMapping(value="/adminCheck/adminGoodsDelete", method=RequestMethod.GET)
	public @ResponseBody String delete(@RequestParam String goods_Code, HttpSession session) {
		System.out.println(goods_Code);
		service.adminGoodsDelete(goods_Code);
		Page list = goodsService.goodsAllPage(1);
		session.setAttribute("page",list);
		
		return "success";
	}
	@RequestMapping(value="/adminCheck/adminGoodsDeleteAll", method=RequestMethod.GET)
	public String deleteAll(@RequestParam List<String> check) {
		System.out.println(check);
		service.adminDeleteAll(check);
		return "redirect:./adminGoods";
	}
	
	@RequestMapping(value="/adminCheck/adminMember", method=RequestMethod.GET)
	public String adminMember(@RequestParam(required=false) Integer currentPage, HttpSession session) {
		if(currentPage == null || currentPage == 0 ){
			currentPage = 1;
		}
		Page list = service.adminMember(currentPage);	
		System.out.println("adminMember    "+list);
		session.setAttribute("page",list);
		return "redirect:../adminPage2";
	}
	
	@RequestMapping(value="/adminCheck/adminMemberDelete", method=RequestMethod.GET)
	public @ResponseBody String adminMemberDelete(@RequestParam String userid) {
		System.out.println(userid);
		service.adminMemberDelete(userid);

		return "success";
	}
	
	@RequestMapping(value="/adminCheck/adminMemberDeleteAll", method=RequestMethod.GET)
	public String adminMemberDeleteAll(@RequestParam List<String> check) {
		System.out.println(check);
		service.adminMemberDeleteAll(check);
		return "redirect:./adminMember";
	}
	

	
	
}
