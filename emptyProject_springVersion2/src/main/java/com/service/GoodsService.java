package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.GoodsDAO;
import com.dto.Goods;

import oracle.net.aso.s;

@Service
public class GoodsService {

	@Autowired
	GoodsDAO dao ; 

	
	//단일제품보기
	public Goods goodsRetrieve(String goods_Code) {
		return dao.goodsRetrieve(goods_Code); 
	}

	
	 //new 모두보기
	public List<Goods> goodsAll(){
		return dao.goodsAll(); 
	}
	
	
	
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

	public List<Goods> goodsSortColorAll(HashMap<String, Object> map) {
		List<Goods> list = dao.goodsSortColorAll(map);
		return list;
	}

	public List<Goods> goodsSortBrandAll(HashMap<String, Object> map) {
		List<Goods> list = dao.goodsSortBrandAll(map);
		return list;
	}

	public List<Goods> goodsSortBrandColorAll(HashMap<String, Object> map) {
		List<Goods> list = dao.goodsSortBrandColorAll(map);
		return list;
	}

	public List<Goods> goodsSortHighAll() {
		List<Goods> list = dao.goodsSortHighAll();
		return list;
	}

	public List<Goods> goodsSortLowAll() {
		List<Goods> list = dao.goodsSortLowAll();
		return list;
	}

	public List<String> colorChartAll() {
		List<String> colorChart = dao.colorChartAll();
		return colorChart;
	}

	public List<String> brandChartAll() {
		List<String> brandChart = dao.brandChartAll();
		return brandChart;
	}

	
}
