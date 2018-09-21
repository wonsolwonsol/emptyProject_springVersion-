package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.dto.Notice;

public class NoticeDAO {
	@Autowired
	SqlSessionTemplate template ;
	
	
	//목록 (이전버전과 달리 목록읽기와 내용보기 분리할 것, 내용은 후자에서만 보일 것) 
	public List<Notice> NoticeAll() {
		return template.selectList("NoticeMapper.noticeAll"); 
	}
	
}
