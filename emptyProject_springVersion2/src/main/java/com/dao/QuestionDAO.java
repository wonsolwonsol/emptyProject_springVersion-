package com.dao;

import java.util.List;
import java.util.Random;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.Notice;

import com.dto.Page2;
import com.dto.Question;
import com.dto.Question_Comments;

@Repository
public class QuestionDAO {
	@Autowired
	SqlSessionTemplate t ;	
	//Comment from question_board_comment
	// author, comment_contents, comment_number, question_number 
	public List<Question_Comments> questionComment(String question_number){
		System.out.println("Question_CommentsDAO=========="+question_number);
		System.out.println(t);
		List<Question_Comments> qc = t.selectList("QuestionMapper.questionComment", question_number); 
		
		return qc ; 
	}
	
	// total Record 
	public int totalRecord() {
		System.out.println("=========chchchc"+t);
		int n = t.selectOne("QuestionMapper.totalCount"); 
		System.out.println("====totalRecord of Question   "+n);
		return n; 
	}
	
	// 목록 
	public Page2 questionAll(int curpage) {
		Page2 page = new Page2() ; //list 3 
		System.out.println("=========chchchc"+t);
		//offset 데이터 인덱스 값
				int offset = (curpage - 1) * page.getPerPage();
				//page에 담을 list (인덱스부터 perpage 갯수 만큼)
				List<Question> list = t.selectList("QuestionMapper.questionAll", null, 
						new RowBounds(offset,page.getPerPage()));
				System.out.println("questionAll in DAO =====");
				page.setList(list); 
				page.setCurrentPage(curpage);
				int totalCount = totalRecord();
				page.setTotalCount(totalCount);
				return page ; 
	}

	// questionRetrieve
	public Question questionRetrieve(String question_number){
		System.out.println("questionRetrieveDAO 확인====="+ question_number);
		Question q = t.selectOne("QuestionMapper.questionRetrieve", question_number); 
		return q; 
	}
	
	//questionDelete 
	public int questionDelete(int question_number) {
		System.out.println("questionDelete DAO             >>" + question_number);
		int n = t.delete("QuestionMapper.questionDelete", question_number); 
		return n; 
	}
	
	//questionCommentDelete
	public int questionCommentDelete(int comment_number) {
		System.out.println("questionCommentDelete   DAO ==============="+comment_number); 
		int n = t.delete("QuestionMapper.questionCommentDelete", comment_number);
		return n;
		
	}
	
	//questionWriteSubmit
	public void questionWriteSubmit(Question question) {
		t.insert("QuestionMapper.questionWriteSubmit", question); 
	}
	
	//questionUpdate
	public void questionUpdate(Question question) {
		t.update("QuestionMapper.questionUpdate", question); 
		System.out.println("questionUpdate DAO >>>>>>>"+question);
	}
	
}


