package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CartDAO;
import com.dao.ReviewDAO;

@Service
public class ReviewBoardService {

	@Autowired
	ReviewDAO dao; 
	
}
