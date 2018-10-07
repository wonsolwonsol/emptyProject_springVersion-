package com.dao;

import java.util.List;
import java.util.Random;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.Notice;
import com.dto.Page;
import com.dto.Question;

@Repository
public class QuestionDAO {
	@Autowired
	SqlSessionTemplate t ;
	
	
	// total Record 
	public int totalRecord() {
		int n = t.selectOne("QuestionMapper.totalCount"); 
		System.out.println("====totalRecord of Question   "+n);
		return n; 
	}
	
	// 목록 
	public Page questionAll(int curpage) {
		Page page = new Page() ; //list 3 
		
		//offset 데이터 인덱스 값
				int offset = (curpage - 1) * page.getPerPage();
				//page에 담을 list (인덱스부터 perpage 갯수 만큼)
				List<Question> list = t.selectList("QuestionMapper.questionAll", null, 
						new RowBounds(offset,page.getPerPage()));
				System.out.println("questionAll in DAO =====");
				page.setQlist(list); 
				page.setCurrentPage(curpage);
				int totalCount = totalRecord();
				page.setTotalCount(totalCount);
				return page ; 
	}

	
	
	
}


