package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.Goods;
@Repository
public class GoodsDAO {	
	@Autowired
	SqlSessionTemplate template ;
	
	
	
	public Goods goodsRetrieve(SqlSession session, 
			String goods_Code) {
		Goods dao 
		= session.selectOne("GoodsMapper.", goods_Code);
	return dao; 
	}
	
	
	
	//new 모두보기
	public List<Goods> goodsAll(){
		return template.selectList("GoodsMapper.goodsAll"); 
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

	
}
