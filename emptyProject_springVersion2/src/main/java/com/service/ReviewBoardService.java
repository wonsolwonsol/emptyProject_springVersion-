package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CartDAO;
import com.dao.ReviewDAO;
import com.dto.Page3;
import com.dto.Review;
import com.dto.ReviewComment;
import com.dto.ReviewJoin;

@Service
public class ReviewBoardService {

	@Autowired
	ReviewDAO dao; 
	
	public Review reviewRetrieve(String review_number){
		dao.updateReadCnt(review_number);
		Review review = dao.reviewRetrieve(review_number);
		System.out.println("review Service           >>>>>"+review);
		return review; 
	}
	
	public List<ReviewJoin> reviewRetrieveJoin(String review_number) {
		List<ReviewJoin> rj = dao.reviewRetrieveJoin(review_number);
		dao.updateReadCnt(review_number);
		System.out.println("Service reviewRetrieveJoin =========================");
		return rj; 
	}
	
	public Page3 review(int curpage){
		Page3 page = dao.review(curpage);
	
		return page ; 
		
	}
	 public void reviewDelete(int review_number) {
         dao.reviewDelete(review_number); }
   public void reviewUpdate(Review review) {
         dao.reviewUpdate(review);  }
   public void reviewWrite(Review review) {
         dao.reviewWrite(review);
   }
   
   public void ReviewCommentInsert(ReviewComment rc) {
	   dao.reviewCommentInsert(rc);
   }
   
	
}
