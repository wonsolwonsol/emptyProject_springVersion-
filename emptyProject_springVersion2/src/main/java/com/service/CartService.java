package com.service;

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
}
