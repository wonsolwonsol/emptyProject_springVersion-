package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dto.Cart;
import com.dto.Goods;
import com.dto.Member;
import com.service.CartService;

@Controller
public class CartController {
	@Autowired
	CartService service;
	
	@RequestMapping("/loginCheck/goodsCart")
	public String goodsCart(Cart cart, RedirectAttributes red, HttpSession session) {
		Member member = (Member) session.getAttribute("member");		
		cart.setUserid(member.getUserid());
		int n = service.goodsCart(cart);
		System.out.println(n);
		red.addFlashAttribute("mesg", cart.getGoods_Name()+" 이 카트에 저장되었습니다.");
		return "redirect:../goodsRetrieve?goods_Code="+cart.getGoods_Code();
	}
	
	@RequestMapping("/loginCheck/cartlist")
	public String goodsList(HttpSession session, RedirectAttributes red) {
		Member member = (Member) session.getAttribute("member");
		List<Cart> list = service.goodsList(member.getUserid());
		red.addFlashAttribute("cartList", list);
		System.out.println("service     "+list);
		return "redirect:../cartList";
		
	}
	
/*	@RequestMapping("/goodsCartDel")
	public @ResponseBody String goodsCartDel(@RequestParam int num) {
		int n = service.goodsCartDel(num);
		System.out.println(num);
		System.out.println(n);
		return ;
	}*/
}
