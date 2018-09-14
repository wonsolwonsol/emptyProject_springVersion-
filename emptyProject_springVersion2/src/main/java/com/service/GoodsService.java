package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.GoodsDAO;
import com.dto.Goods;

@Service
public class GoodsService {

	@Autowired
	GoodsDAO dao ; 

	 //모두보기
	public List<Goods> GoodsList(){
		return dao.GoodsList();
	}

	
}
