package com.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dto.Goods;
import com.dto.Page;

@Repository
public class AdminDAO {
	@Autowired
	SqlSessionTemplate template;
	
	public int totalCount() {
		int n = template.selectOne("GoodsMapper.totalCount");
		return n;
	}
	
	@RequestMapping
	public Page selectPage(int curPage) {		
		Page page = new Page();
		int offset = (curPage - 1) * page.getPerPage();
		List<Goods> list = template.selectList("GoodsMapper.goodsAll", null, new RowBounds(offset,page.getPerPage())); 
		
		page.setList(list);
		page.setCurrentPage(curPage);
		page.setTotalCount(totalCount());
		
		return page;
	}
}
