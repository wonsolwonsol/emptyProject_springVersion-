package com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CartDAO;
import com.dto.Cart;

@Service
public class CartService {

	@Autowired
	CartDAO dao;

	public int goodsCart(Cart cart) {
		int n = dao.goodsCart(cart);
		return n;
	}

	public List<Cart> goodsList(String userid) {
		List<Cart> list = dao.goodsList(userid);
		return list;
	}

	public int goodsCartDel(int num) {
		int n = dao.goodsCartDel(num);
		return n;
	}

	public int goodsCartUpdate(HashMap<String, Integer> map) {
		int n = dao.goodsCartUpdate(map);
		return n;
	}

	public int goodsCartDelAll(ArrayList<String> list) {
		int n = dao.goodsCartDelAll(list);
		return n;
	}

	public Cart cartToOrder(int num) {
		Cart cart = dao.cartToOrder(num);
		return cart;
	}

	public List<Cart> cartToOrderAll(ArrayList<String> check) {
		List<Cart> list = dao.cartToOrderAll(check);
		return list;
	}
}
