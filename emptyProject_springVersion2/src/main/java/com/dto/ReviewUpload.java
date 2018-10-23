package com.dto;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ReviewUpload {
	private CommonsMultipartFile theFile; 
	private int review_number;
	private String title ;
	private String author;
	private String content;
	private String image_name; 
	private String term;
	private String regdate ;
	private int readcnt ;
	public CommonsMultipartFile getTheFile() {
		return theFile;
	}
	public void setTheFile(CommonsMultipartFile theFile) {
		this.theFile = theFile;
	}
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
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
	public int getReadcnt() {
		return readcnt;
	}
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
	@Override
	public String toString() {
		return "ReviewUpload [theFile=" + theFile + ", review_number=" + review_number + ", title=" + title
				+ ", author=" + author + ", content=" + content + ", image_name=" + image_name + ", term=" + term
				+ ", regdate=" + regdate + ", readcnt=" + readcnt + "]";
	}
	public ReviewUpload(CommonsMultipartFile theFile, int review_number, String title, String author, String content,
			String image_name, String term, String regdate, int readcnt) {
		super();
		this.theFile = theFile;
		this.review_number = review_number;
		this.title = title;
		this.author = author;
		this.content = content;
		this.image_name = image_name;
		this.term = term;
		this.regdate = regdate;
		this.readcnt = readcnt;
	}
	public ReviewUpload() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
