package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.NoticeDAO;
import com.dto.Notice;



@Service
public class NoticeService {

	
	@Autowired
	NoticeDAO dao; 
	//모두(목록)보기 
	public List<Notice> noticeAll(){
		return dao.noticeAll(); 
	}

}
