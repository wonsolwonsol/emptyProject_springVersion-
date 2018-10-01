package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
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
import com.service.MemberService;

@Controller
public class CartController {
	@Autowired
	CartService service;
	@Autowired
	MemberService memService;
	
	
	@RequestMapping("/loginCheck/goodsCart")
	public String goodsCart(Cart cart, RedirectAttributes red, HttpSession session) {
		Member member = (Member) session.getAttribute("member");		
		cart.setUserid(member.getUserid());
		int n = service.goodsCart(cart);
		red.addFlashAttribute("mesg", cart.getGoods_Name()+" 이 카트에 저장되었습니다.");
		return "redirect:../goodsRetrieve?goods_Code="+cart.getGoods_Code();
	}
	
	@RequestMapping("/loginCheck/cartlist")
	public String goodsList(HttpSession session) {
		Member member = (Member) session.getAttribute("member");
		List<Cart> list = service.goodsList(member.getUserid());
		session.setAttribute("cartList", list);
		return "redirect:../cartList";		
	}
	
	@RequestMapping("/loginCheck/goodsCartDel")
	public @ResponseBody String goodsCartDel(@RequestParam int num) {
		int n = service.goodsCartDel(num);
		return "success";
	}
	
	@RequestMapping("/loginCheck/goodsCartUpdate")
	public @ResponseBody String goodsCartUpdate(@RequestParam HashMap<String, Integer> map) {		
		int n = service.goodsCartUpdate(map);
		return "success";
	}
	
	@RequestMapping("/loginCheck/goodsCartDelAll")
	public String goodsCartDelAll(@RequestParam("check") ArrayList<String> list) {
		int n = service.goodsCartDelAll(list);
		return "redirect:./cartlist";
	}
	
	@RequestMapping("/loginCheck/cartToOrder")
	public String cartToOrder(@RequestParam int num, HttpSession session, RedirectAttributes red) {
		Member mem = (Member) session.getAttribute("login");
		Cart cart = service.cartToOrder(num);
		red.addAttribute("cart", cart);
		red.addAttribute("member", mem);
		
		return "redirect:./cartToOrder";		
	}
	
}
