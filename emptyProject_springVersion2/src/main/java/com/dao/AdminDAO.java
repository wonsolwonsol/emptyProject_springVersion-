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
	
	public Page selectPage(int curPage) {		
		Page page = new Page();
		int offset = (curPage - 1) * page.getPerPage();
		List<Goods> list = template.selectList("GoodsMapper.goodsAll", null, new RowBounds(offset,page.getPerPage())); 
		
		page.setList(list);
		page.setCurrentPage(curPage);
		page.setTotalCount(totalCount());
		
		return page;
	}

	public void adminGoodsAdd(Goods goods) {
		template.insert("GoodsMapper.adminGoodsInsert",goods);		
	}

	public void adminGoodsUpdate(Goods goods) {
		template.update("GoodsMapper.adminGoodsUpdate", goods);		
	}

	public void adminGoodsUpdateNoImg(Goods goods) {
		template.update("GoodsMapper.adminGoodsUpdateNoImg", goods);
		
	}
	
	public void adminGoodsDelete(String goods_Code) {
		template.delete("GoodsMapper.adminGoodsDel", goods_Code);
		
	}

	public Goods adminGoodsCode(String goods_Code) {
		Goods goods = template.selectOne("GoodsMapper.adminGoodsSelect", goods_Code);
		return goods;
	}

	public void adminGoodsDeleteAll(List<String> check) {
		template.delete("GoodsMapper.adminGoodsDelAll", check);
		
	}

	public int totalRecord() {
		//데이터의 총 갯수
		int n = template.selectOne("MemberMapper.totalCount");
		System.out.println("totalRecord    "+n);
		return n;
	}
	
	public Page adminMember(Integer curpage) {
		Page page = new Page();
		//offset 데이터 인덱스 값
		int offset = (curpage - 1) * page.getPerPage();
		//page에 담을 list (인덱스부터 perpage 갯수 만큼)
		List<Goods> list = template.selectList("MemberMapper.memberAll", null, 
				new RowBounds(offset,page.getPerPage()));
		
		page.setList(list);
		page.setCurrentPage(curpage);
		int totalCount = totalRecord();
		page.setTotalCount(totalCount);
		return page;
	
	}

	public void adminMemberDelete(String userid) {
		template.delete("MemberMapper.adminMemberDelete", userid);			
	}

	public void adminMemberDeleteAll(List<String> check) {
		template.delete("MemberMapper.adminMemberDeleteAll",check);		
	}


}
