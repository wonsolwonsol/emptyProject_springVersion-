package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CartDAO;
import com.dao.QuestionDAO;
import com.dto.Page2;
import com.dto.Question;

@Service
public class QuestionBoardService {

	@Autowired
	QuestionDAO dao; 
	
	public Page2 questionAll(int curpage) {
		Page2 page = dao.questionAll(curpage); 
		System.out.println("QuestionAll in Service =======");
		return page; 
	}
	
	//questionRetrieve
	public Question questionRetrieve(String question_number) {
		return dao.questionRetrieve(question_number); 
	}
	
	//questionDelete 
	public int questionDelete(int question_number) {
		//QuestionDAO dao = new QuestionDAO();
		int n = dao.questionDelete(question_number); 
		return n; 
	}
	//questionWriteSubmit
	public void questionWriteSubmit(Question question) {
		dao.questionWriteSubmit(question);
		
	}
	
	//questionUpdate
	public void questionUpdate(Question question) {
		
		dao.questionUpdate(question); 
		
	}
	public void questionAdminDelAll(List<String> check) {
		
		dao.questionAdminDelAll(check);
	}
	
	
}
