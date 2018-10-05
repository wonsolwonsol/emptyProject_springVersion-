package com.dao;

import java.util.List;
import java.util.Random;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
/*	public Question questionAll(int curpage) {
		Page page = new Page() ; //list 3 
		
		
	}*/

	
	
	
}


