package com.dto;

public class Question_Comments {

	private String author; 
	private String comment_contents;
	private String comment_num ; 
	private String fk_question_num;
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getComment_contents() {
		return comment_contents;
	}
	public void setComment_contents(String comment_contents) {
		this.comment_contents = comment_contents;
	}
	public String getComment_num() {
		return comment_num;
	}
	public void setComment_num(String comment_num) {
		this.comment_num = comment_num;
	}
	public String getFk_question_num() {
		return fk_question_num;
	}
	public void setFk_question_num(String fk_question_num) {
		this.fk_question_num = fk_question_num;
	}
	@Override
	public String toString() {
		return "Question_Comment [author=" + author + ", comment_contents=" + comment_contents + ", comment_num="
				+ comment_num + ", fk_question_num=" + fk_question_num + "]";
	}
	public Question_Comments(String author, String comment_contents, String comment_num, String fk_question_num) {
		super();
		this.author = author;
		this.comment_contents = comment_contents;
		this.comment_num = comment_num;
		this.fk_question_num = fk_question_num;
	}
	public Question_Comments() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
