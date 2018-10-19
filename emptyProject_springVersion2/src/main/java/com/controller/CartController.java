package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dto.Cart;
import com.dto.Goods;
import com.dto.Member;
import com.dto.Order;
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
	
	@RequestMapping(value="/loginCheck/goodsDirectCart", method=RequestMethod.POST, produces="application/text; charset=utf8")
	public @ResponseBody String goodsDirectCart(@RequestParam String goods_Code, @RequestParam int currentPage, HttpSession session) {
		Goods goods = service.goodsSelect(goods_Code);		
		Member member = (Member) session.getAttribute("member");	
		System.out.println(member);
		System.out.println(goods);
		Cart cart = new Cart();				
		cart.setUserid(member.getUserid());
		cart.setGoods_Amount(1);
		cart.setGoods_Brand(goods.getGoods_Brand());
		cart.setGoods_Code(goods_Code);
		cart.setGoods_Color(goods.getGoods_Color());
		cart.setGoods_Image(goods.getGoods_Image1());
		cart.setGoods_Name(goods.getGoods_Name());
		int price = Integer.parseInt(goods.getGoods_Price());
		cart.setGoods_Price(price);		
		
		service.goodsCart(cart);
		String mesg = cart.getGoods_Name()+" 이 카트에 저장되었습니다.";
		
		return mesg;
	}
	
	@RequestMapping("/loginCheck/cartlist")
	public String goodsList(HttpSession session) {
		Member member = (Member) session.getAttribute("member");
		List<Cart> list = service.goodsList(member.getUserid());
		session.setAttribute("cartList", list);
		return "redirect:../cartList";		
	}
	
	@RequestMapping("/loginCheck/goodsCartDel")
	public @ResponseBody String goodsCartDel(@RequestParam int num,  HttpSession session) {
		int n = service.goodsCartDel(num);
		goodsList(session);
		return "success";
	}
	
/*	@RequestMapping("/loginCheck/goodsCartUpdate")
	public @ResponseBody String goodsCartUpdate(@RequestParam HashMap<String, Integer> map, HttpSession session) {	
		int n = service.goodsCartUpdate(map);
		goodsList(session);
		return "success";
	}*/
	
	@RequestMapping("/loginCheck/goodsCartUpdate")
	public String goodsCartUpdate(@RequestParam HashMap<String, Integer> map, HttpSession session) {	
		int n = service.goodsCartUpdate(map);
		goodsList(session);
		return "redirect:./cartlist";
	}
	
	@RequestMapping("/loginCheck/goodsCartDelAll")
	public String goodsCartDelAll(@RequestParam("check") ArrayList<String> list) {
		int n = service.goodsCartDelAll(list);
		return "redirect:./cartlist";
	}
	
	@RequestMapping("/loginCheck/cartToOrder")
	public String cartToOrder(@RequestParam int num, HttpSession session) {
		Member mem = (Member) session.getAttribute("member");
		Cart cart = service.cartToOrder(num);
//		red.addFlashAttribute("cart", cart);
//		red.addFlashAttribute("member", mem);
		session.setAttribute("orderTemp", cart);
		session.setAttribute("member", mem);
		System.out.println(session);
		return "redirect:../cartToOrder";
	}
	
	@RequestMapping("/loginCheck/cartToOrderAll")
	public String cartToOrderAll(@RequestParam("check") ArrayList<String> check, HttpSession session) {
		Member mem = (Member) session.getAttribute("member");
		List<Cart> list = service.cartToOrderAll(check);
		session.setAttribute("orderTemp", list);
		session.setAttribute("member", mem);
		return "redirect:../cartToOrderAll";
	}
	
	@RequestMapping(value="/loginCheck/orderConfirm", method=RequestMethod.POST)
	public String orderConfirm(Order order, HttpSession session, 
			@RequestParam String phone1 , @RequestParam String phone2, @RequestParam String phone3) {
		Member mem = (Member) session.getAttribute("member");
		String phone = phone1+phone2+phone3;
		order.setUserid(mem.getUserid());
		order.setPhone(phone);
		System.out.println(order);
		
		Order list = service.orderConfirm(order);
		session.setAttribute("order", list);
		System.out.println(list);
		return "redirect:../orderConfirm";
	}
	@RequestMapping(value="/loginCheck/orderConfirmAll", method=RequestMethod.GET)
	public String orderConfirmAll(@RequestParam("num") ArrayList<String> num, HttpSession session, Order ord,
			@RequestParam String phone1 , @RequestParam String phone2, @RequestParam String phone3) {
		Member mem = (Member) session.getAttribute("member");		
		List<Cart> cList = service.cartToOrderAll(num);
		List<Order> oList = new ArrayList();
		
		for (Cart cart : cList) {
			Order order = new Order();
			order.setAddr1(ord.getAddr1());
			order.setAddr2(ord.getAddr2());
			order.setPayMethod(ord.getPayMethod());
			order.setPhone(phone1+phone2+phone3);
			order.setUserid(mem.getUserid());
			order.setUsername(ord.getUsername());
			order.setPost(ord.getPost());
			order.setGoods_Amount(cart.getGoods_Amount());
			order.setGoods_Brand(cart.getGoods_Brand());
			order.setGoods_Code(cart.getGoods_Code());
			order.setGoods_Color(cart.getGoods_Color());
			order.setGoods_Image(cart.getGoods_Image());
			order.setGoods_Name(cart.getGoods_Name());
			order.setGoods_Price(cart.getGoods_Price());
			order.setNum(cart.getNum());
			oList.add(order);
		}
		service.orderConfirmAll(oList, num);
		session.setAttribute("orderAll", oList);
		
		return "redirect:../orderConfirmAll";
	}
	
}
