package com.dto;

import org.apache.ibatis.type.Alias;

@Alias("ReviewComment")
public class ReviewComment {

	
	private String author;
	private String regdate;
	private String content;
	private String review_number;
	private String r_comment_number;
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReview_number() {
		return review_number;
	}
	public void setReview_number(String review_number) {
		this.review_number = review_number;
	}
	public String getR_comment_number() {
		return r_comment_number;
	}
	public void setR_comment_number(String r_comment_number) {
		this.r_comment_number = r_comment_number;
	}
	@Override
	public String toString() {
		return "ReviewComment [author=" + author + ", regdate=" + regdate + ", content=" + content + ", review_number="
				+ review_number + ", r_comment_number=" + r_comment_number + "]";
	}
	public ReviewComment(String author, String regdate, String content, String review_number, String r_comment_number) {
		super();
		this.author = author;
		this.regdate = regdate;
		this.content = content;
		this.review_number = review_number;
		this.r_comment_number = r_comment_number;
	}
	public ReviewComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
