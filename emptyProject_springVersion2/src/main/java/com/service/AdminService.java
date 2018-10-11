package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AdminDAO;
import com.dto.Goods;
import com.dto.Page;

@Service
public class AdminService {
	@Autowired
	AdminDAO dao;

	public void adminGoodsAdd(Goods goods) {
		dao.adminGoodsAdd(goods);		
	}

	public void adminGoodsUpdate(Goods goods) {
		dao.adminGoodsUpdate(goods);		
	}

	public void adminGoodsDelete(String goods_Code) {
		dao.adminGoodsDelete(goods_Code);
		
	}

	public Goods adminUpdateCode(String goods_Code) {
		Goods goods = dao.adminGoodsCode(goods_Code);
		return goods;		
	}

	public void adminDeleteAll(List<String> check) {
		dao.adminGoodsDeleteAll(check);
		
	}

	public Page adminMember(Integer currentPage) {
		Page page = dao.adminMember(currentPage);
		return page;
	}

	public void adminMemberDelete(String userid) {
		dao.adminMemberDelete(userid);
		
	}

	public void adminMemberDeleteAll(List<String> check) {
		dao.adminMemberDeleteAll(check);
		
	}
}
