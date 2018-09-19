package com.service;

import java.util.HashMap;
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
	public List<Goods> goodsList(String goods_Category) {
		List<Goods> list = dao.goodsList(goods_Category);
		return list;
	}

	public List<String> colorChart(String goods_Category) {
		List<String> colorChart = dao.colorChart(goods_Category);
		return colorChart;
	}

	public List<String> brandChart(String goods_Category) {
		List<String> brandChart = dao.brandChart(goods_Category);
		return brandChart;
	}

	public List<String> goodsSortColor(HashMap<String, Object> map) {
		List<String> list = dao.goodsSortColor(map);
		return list;
	}

	public List<String> goodsSortBrand(HashMap<String, Object> map) {
		List<String> list = dao.goodsSortBrand(map);
		return list;
	}

	public List<String> goodsSortBrandColor(HashMap<String, Object> map) {
		List<String> list = dao.goodsSortBrandColor(map);
		return list;
	}

	public List<Goods> goodsSortHigh(String category) {
		List<Goods> list = dao.goodsSortHigh(category);
		return list;
	}

	public List<Goods> goodsSortLow(String category) {
		List<Goods> list = dao.goodsSortLow(category);
		return list;
	}

	
}
