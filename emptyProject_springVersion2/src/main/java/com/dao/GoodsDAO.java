package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.Goods;
import com.dto.Page;
@Repository
public class GoodsDAO {	
	@Autowired
	SqlSessionTemplate template ;
	
	
	
	public Goods goodsRetrieve(String goods_Code) {
		Goods dao 
		= template.selectOne("GoodsMapper.goodsRetrieve", goods_Code);
	return dao; 
	}
	
	
	
	//new 모두보기
	public List<Goods> goodsAll(){
		List<Goods> list = template.selectList("GoodsMapper.goodsAll");
		
		return list;
		
	}
	
	
	//각 카테고리별 리스트보기 
	public List<Goods> goodsList(String goods_Category){
		List<Goods> list = template.selectList("GoodsMapper.goodsList", goods_Category); 
		return list ; 
	}

	public List<String> colorChart(String goods_Category) {
		List<String> colorChart = template.selectList("GoodsMapper.colorChart", goods_Category);
		return colorChart;
	}

	public List<String> brandChart(String goods_Category) {
		List<String> brandChart = template.selectList("GoodsMapper.brandChart", goods_Category);
		return brandChart;
	}

	public List<String> goodsSortColor(HashMap<String, Object> map) {
		List<String> list = template.selectList("GoodsMapper.goodsSortColor", map);
		return list;
	}

	public List<String> goodsSortBrand(HashMap<String, Object> map) {
		List<String> list = template.selectList("GoodsMapper.goodsSortBrand", map);
		return list;
	}

	public List<String> goodsSortBrandColor(HashMap<String, Object> map) {
		List<String> list = template.selectList("GoodsMapper.goodsSortBrandColor", map);
		return list;
	}

	public List<Goods> goodsSortHigh(String category) {
		List<Goods> list = template.selectList("GoodsMapper.goodsSortHigh", category);
		return list;
	}

	public List<Goods> goodsSortLow(String category) {
		List<Goods> list = template.selectList("GoodsMapper.goodsSortLow", category);
		return list;
	}

	public List<Goods> goodsSortColorAll(HashMap<String, Object> map) {
		List<Goods> list = template.selectList("GoodsMapper.goodsSortColorAll", map);
		return list;
	}

	public List<Goods> goodsSortBrandAll(HashMap<String, Object> map) {
		List<Goods> list = template.selectList("GoodsMapper.goodsSortBrandAll", map);
		return list;
	}

	public List<Goods> goodsSortBrandColorAll(HashMap<String, Object> map) {
		List<Goods> list = template.selectList("GoodsMapper.goodsSortBrandColorAll", map);
		return list;
	}

	public List<Goods> goodsSortHighAll() {
		List<Goods> list = template.selectList("GoodsMapper.goodsSortHighAll");
		return list;
	}

	public List<Goods> goodsSortLowAll() {
		List<Goods> list = template.selectList("GoodsMapper.goodsSortLowAll");
		return list;
	}

	public List<String> colorChartAll() {
		List<String> list = template.selectList("GoodsMapper.colorChartAll");
		return list;
	}
	
	public List<String> brandChartAll() {
		List<String> list = template.selectList("GoodsMapper.brandChartAll");
		return list;
	}

	public int totalRecord() {
		//데이터의 총 갯수
		int n = template.selectOne("GoodsMapper.totalCount");
		System.out.println("totalRecord    "+n);
		return n;
	}
	
	public Page goodsAllPage(int curpage) {
		Page page = new Page();
		//offset 데이터 인덱스 값
		int offset = (curpage - 1) * page.getPerPage();
		page.setPerPage(8);
		//page에 담을 list (인덱스부터 perpage 갯수 만큼)
		List<Goods> list = template.selectList("GoodsMapper.goodsAll", null, new RowBounds(offset,page.getPerPage()));
		
		page.setList(list);
		page.setCurrentPage(curpage);
		int totalCount = totalRecord();
		page.setTotalCount(totalCount);
		return page;
	}

	
}
