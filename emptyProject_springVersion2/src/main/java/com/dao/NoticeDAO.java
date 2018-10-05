package com.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.Notice;
import com.dto.Page;
@Repository
public class NoticeDAO {
	@Autowired
	SqlSessionTemplate template ;
	
	
	//목록 (이전버전과 달리 목록읽기와 내용보기 분리할 것, 내용은 후자에서만 보일 것) 
	public List<Notice> noticeAll() {
		return template.selectList("NoticeMapper.noticeAll"); 
	}
	
	
	//totalRecord of Notice 
	public int totalRecord() {
		//데이터의 총 갯수
		int n = template.selectOne("NoticeMapper.totalCount");
		System.out.println("★★★★★★★★★★★★★★★★★★★★★");
		System.out.println("totalRecord    "+n);
		return n;
		
	}
	
	//paging 처리한 목록
	public Page noticeAll2(int curpage) {
		Page page = new Page(); 
		//offset 데이터 인덱스 값
		int offset = (curpage - 1) * page.getPerPage();
		//page에 담을 list (인덱스부터 perpage 갯수 만큼)
		List<Notice> list = template.selectList("NoticeMapper.noticeAll", null, 
				new RowBounds(offset,page.getPerPage()));
		System.out.println("noticeAll in DAO =====");
		page.setList2(list); 
		page.setCurrentPage(curpage);
		int totalCount = totalRecord();
		page.setTotalCount(totalCount);
		return page ; 
	}
	
	
}
