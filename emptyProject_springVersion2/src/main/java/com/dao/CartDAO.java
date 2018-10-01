package com.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.Cart;

@Repository
public class CartDAO {
	@Autowired
	SqlSessionTemplate template;

	public int goodsCart(Cart cart) {
		int n = template.insert("CartMapper.cartAdd",cart);
		return n;
	}

	public List<Cart> goodsList(String userid) {
		List<Cart> list = template.selectList("CartMapper.cartList",userid);
		return list;
	}

	public int goodsCartDel(int num) {
		int n = template.delete("CartMapper.cartDel",num);
		return n;
	}

	public int goodsCartUpdate(HashMap<String, Integer> map) {
		int n = template.update("CartMapper.cartUpdate", map);
		return n;
	}

	public int goodsCartDelAll(ArrayList<String> list) {
		int n = template.delete("CartMapper.cartDelAll",list);
		return n;
	}

	public Cart cartToOrder(int num) {
		Cart cart = template.selectOne("CartMapper.cartToOrder", num);
		return cart;
	}

	public List<Cart> cartToOrderAll(ArrayList<String> check) {
		List<Cart> list = template.selectList("CartMapper.cartToOrderAll", check);
		return list;
	}

}
