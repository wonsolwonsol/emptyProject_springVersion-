package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

}
