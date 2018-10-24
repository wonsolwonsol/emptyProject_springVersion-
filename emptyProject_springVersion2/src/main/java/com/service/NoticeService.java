package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.NoticeDAO;
import com.dto.Notice;
import com.dto.Page;



@Service
public class NoticeService {

	
	@Autowired
	NoticeDAO dao; 
	//자세히보기
	public Notice noticeRetrieve(String seq) {
		return dao.noticeRetrieve(seq); 
	}
	//모두(목록)보기 
	public List<Notice> noticeAll(){
		return dao.noticeAll(); 
	}
	
	//페이징추가한 목록보기
	public Page noticeAll2(int curpage) {
		Page page = dao.noticeAll2(curpage); 
		System.out.println("noticeAll2 in Service =======");
		return page; 
		
	}
	

}
