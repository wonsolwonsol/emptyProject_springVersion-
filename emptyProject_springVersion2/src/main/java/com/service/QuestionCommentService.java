package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.QuestionDAO;
import com.dto.Question_Comments;

@Service
public class QuestionCommentService {
	@Autowired
	QuestionDAO dao; 
	
	// Question_Comments
	public List<Question_Comments> Question_Comments(String question_number){
		//QuestionDAO dao = new QuestionDAO(); ==> t 에러 
		List<Question_Comments> qc = dao.questionComment(question_number); 
		return qc; 
	}

	//questionCommentDelete
	public int questionCommentDelete(int comment_number) {
		int n = dao.questionCommentDelete(comment_number); 
		return n; 
	}
	
	//questionCommentWrite
	public void questionCommentWrite(Question_Comments qc) {
		System.out.println("QuestionComment Service >>>>>>>"+qc);
		dao.questionCommentWrite(qc);
	}
}
