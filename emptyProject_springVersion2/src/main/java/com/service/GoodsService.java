package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.GoodsDAO;
import com.dto.Goods;
import com.dto.Page;

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
	public Page goodsList(String goods_Category, int currentPage) {
		Page list = dao.goodsList(goods_Category, currentPage);
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

	public Page goodsSortColor(HashMap<String, Object> map) {
		Page list = dao.goodsSortColor(map);
		return list;
	}

	public Page goodsSortBrand(HashMap<String, Object> map) {
		Page list = dao.goodsSortBrand(map);
		return list;
	}

	public Page goodsSortBrandColor(HashMap<String, Object> map) {
		Page list = dao.goodsSortBrandColor(map);
		return list;
	}

	public Page goodsSortHigh(String category) {
		Page list = dao.goodsSortHigh(category);
		return list;
	}

	public Page goodsSortLow(String category) {
		Page list = dao.goodsSortLow(category);
		return list;
	}

	public Page goodsSortColorAll(HashMap<String, Object> map) {
		Page list = dao.goodsSortColorAll(map);
		return list;
	}

	public Page goodsSortBrandAll(HashMap<String, Object> map) {
		Page list = dao.goodsSortBrandAll(map);
		return list;
	}

	public Page goodsSortBrandColorAll(HashMap<String, Object> map) {
		Page list = dao.goodsSortBrandColorAll(map);
		return list;
	}

	public Page goodsSortHighAll() {
		Page list = dao.goodsSortHighAll();
		return list;
	}

	public Page goodsSortLowAll() {
		Page list = dao.goodsSortLowAll();
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


	public Page goodsAllPage(int curpage) {
		Page page = dao.goodsAllPage(curpage);
		return page;
	}


	public Page goodsSearch(String search) {
		Page page = dao.goodsSearch(search);
		return page;
	}

	
}
