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
		Goods dao = template.selectOne("GoodsMapper.goodsRetrieve", goods_Code);
	return dao; 
	}
	
	//new 모두보기
	public List<Goods> goodsAll(){
		List<Goods> list = template.selectList("GoodsMapper.goodsAll");
		
		return list;		
	}
	
	//각 카테고리별 리스트보기 
	public Page goodsList(String goods_Category, int curpage){
		Page page = new Page();
		int offset = (curpage - 1) * page.getPerPage();
		
		List<Goods> list = template.selectList("GoodsMapper.goodsList", goods_Category, new RowBounds(offset,page.getPerPage())); 
		page.setList(list);
		page.setCurrentPage(curpage);
		int totalCount = totalRecordCate(goods_Category);
		page.setTotalCount(totalCount);
		return page;
	}

	public List<String> colorChart(String goods_Category) {
		List<String> colorChart = template.selectList("GoodsMapper.colorChart", goods_Category);
		return colorChart;
	}

	public List<String> brandChart(String goods_Category) {
		List<String> brandChart = template.selectList("GoodsMapper.brandChart", goods_Category);
		return brandChart;
	}

	public Page goodsSortColor(HashMap<String, Object> map) {
		//생각해보니 데이터가 많지 않아 페이징이 무의미
		//결과값이 많아 페이징 해야 한다면 totalrecord 메서드를 각각 구현해야함
		Page page = new Page();
		List<Goods> list = template.selectList("GoodsMapper.goodsSortColor", map);
		page.setList(list);
		return page;
	}

	public Page goodsSortBrand(HashMap<String, Object> map) {
		List<Goods> list = template.selectList("GoodsMapper.goodsSortBrand", map);
		Page page = new Page();
		page.setList(list);
		return page;
	}

	public Page goodsSortBrandColor(HashMap<String, Object> map) {
		List<Goods> list = template.selectList("GoodsMapper.goodsSortBrandColor", map);
		Page page = new Page();
		page.setList(list);
		return page;
	}

	public Page goodsSortHigh(String category) {
		Page page = new Page();
		
		List<Goods> list = template.selectList("GoodsMapper.goodsSortHigh", category);
		page.setList(list);
		return page;
	}

	public Page goodsSortLow(String category) {
		Page page = new Page();
		
		List<Goods> list = template.selectList("GoodsMapper.goodsSortLow", category);
		page.setList(list);
		
		return page;
	}

	public Page goodsSortColorAll(HashMap<String, Object> map) {
		List<Goods> list = template.selectList("GoodsMapper.goodsSortColorAll", map);
		Page page = new Page();
		page.setList(list);
		return page;
	}

	public Page goodsSortBrandAll(HashMap<String, Object> map) {
		List<Goods> list = template.selectList("GoodsMapper.goodsSortBrandAll", map);
		Page page = new Page();
		page.setList(list);
		return page;
	}

	public Page goodsSortBrandColorAll(HashMap<String, Object> map) {
		List<Goods> list = template.selectList("GoodsMapper.goodsSortBrandColorAll", map);
		Page page = new Page();
		page.setList(list);
		return page;	
	}

	public Page goodsSortHighAll() {
		List<Goods> list = template.selectList("GoodsMapper.goodsSortHighAll");
		Page page = new Page();
		page.setList(list);
		return page;
	}

	public Page goodsSortLowAll() {
		List<Goods> list = template.selectList("GoodsMapper.goodsSortLowAll");
		Page page = new Page();
		page.setList(list);
		return page;
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
	
	public int totalRecordCate(String category) {
		//데이터의 총 갯수
		int n = template.selectOne("GoodsMapper.totalCountCate", category);
		System.out.println("totalRecord    "+n);
		return n;
	}
	
	public Page goodsAllPage(int curpage) {
		Page page = new Page();
		//offset 데이터 인덱스 값
		int offset = (curpage - 1) * page.getPerPage();
		//page에 담을 list (인덱스부터 perpage 갯수 만큼)
		List<Goods> list = template.selectList("GoodsMapper.goodsAll", null, 
				new RowBounds(offset,page.getPerPage()));
		
		page.setList(list);
		page.setCurrentPage(curpage);
		int totalCount = totalRecord();
		page.setTotalCount(totalCount);
		return page;
	}

	public Page goodsSearch(String search) {
		List<Goods> list = template.selectList("GoodsMapper.goodsSearch", search);
		
		Page page = new Page();
		page.setList(list);		
		return page;
	}

	
}
