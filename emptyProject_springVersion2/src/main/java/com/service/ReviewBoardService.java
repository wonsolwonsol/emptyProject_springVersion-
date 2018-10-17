package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CartDAO;
import com.dao.ReviewDAO;
import com.dto.Review;

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
	
}
