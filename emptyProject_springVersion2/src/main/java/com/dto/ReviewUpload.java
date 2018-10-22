package com.dto;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ReviewUpload {
	private CommonsMultipartFile image; 
	private int review_number;
	private String title ;
	private String author;
	private String content;
	private String image_name; 
	private String term;
	private String regdate ;
	private int readcnt ;
	
}
