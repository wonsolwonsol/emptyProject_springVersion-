package com.dto;

import org.apache.ibatis.type.Alias;

@Alias("ReviewJoin")
public class ReviewJoin {

	private String review_review_number;
    private String review_regdate ;
    private String review_title ;
    private String review_author ;
    private String review_readcnt ;
    private String review_content ;
    private String review_comment_author ;
    private String review_comment_content ;
	public String getReview_review_number() {
		return review_review_number;
	}
	public void setReview_review_number(String review_review_number) {
		this.review_review_number = review_review_number;
	}
	public String getReview_regdate() {
		return review_regdate;
	}
	public void setReview_regdate(String review_regdate) {
		this.review_regdate = review_regdate;
	}
	public String getReview_title() {
		return review_title;
	}
	public void setReview_title(String review_title) {
		this.review_title = review_title;
	}
	public String getReview_author() {
		return review_author;
	}
	public void setReview_author(String review_author) {
		this.review_author = review_author;
	}
	public String getReview_readcnt() {
		return review_readcnt;
	}
	public void setReview_readcnt(String review_readcnt) {
		this.review_readcnt = review_readcnt;
	}
	public String getReview_content() {
		return review_content;
	}
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
	public String getReview_comment_author() {
		return review_comment_author;
	}
	public void setReview_comment_author(String review_comment_author) {
		this.review_comment_author = review_comment_author;
	}
	public String getReview_comment_content() {
		return review_comment_content;
	}
	public void setReview_comment_content(String review_comment_content) {
		this.review_comment_content = review_comment_content;
	}
	@Override
	public String toString() {
		return "ReviewJoin [review_review_number=" + review_review_number + ", review_regdate=" + review_regdate
				+ ", review_title=" + review_title + ", review_author=" + review_author + ", review_readcnt="
				+ review_readcnt + ", review_content=" + review_content + ", review_comment_author="
				+ review_comment_author + ", review_comment_content=" + review_comment_content + "]";
	}
	public ReviewJoin(String review_review_number, String review_regdate, String review_title, String review_author,
			String review_readcnt, String review_content, String review_comment_author, String review_comment_content) {
		super();
		this.review_review_number = review_review_number;
		this.review_regdate = review_regdate;
		this.review_title = review_title;
		this.review_author = review_author;
		this.review_readcnt = review_readcnt;
		this.review_content = review_content;
		this.review_comment_author = review_comment_author;
		this.review_comment_content = review_comment_content;
	}
	public ReviewJoin() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
