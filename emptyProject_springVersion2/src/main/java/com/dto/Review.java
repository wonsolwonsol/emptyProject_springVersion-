package com.dto;

import org.apache.ibatis.type.Alias;

@Alias("Review")
public class Review {
	
	private int review_number;
	private String title ;
	private String content;
	private String image_name; 
	private String term;
	private String regdate ;
	public int getReview_number() {
		return review_number;
	}
	public void setReview_number(int review_number) {
		this.review_number = review_number;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImage_name() {
		return image_name;
	}
	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "Review [review_number=" + review_number + ", title=" + title + ", content=" + content + ", image_name="
				+ image_name + ", term=" + term + ", regdate=" + regdate + "]";
	}
	public Review(int review_number, String title, String content, String image_name, String term, String regdate) {
		super();
		this.review_number = review_number;
		this.title = title;
		this.content = content;
		this.image_name = image_name;
		this.term = term;
		this.regdate = regdate;
	}
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
