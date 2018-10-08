package com.dto;

import org.apache.ibatis.type.Alias;

@Alias("Question_Comments")
public class Question_Comments {

	private String author;
	private String comment_contents;
	private int comment_number;
	private int question_number;
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
	public int getComment_number() {
		return comment_number;
	}
	public void setComment_number(int comment_number) {
		this.comment_number = comment_number;
	}
	public int getQuestion_number() {
		return question_number;
	}
	public void setQuestion_number(int question_number) {
		this.question_number = question_number;
	}
	@Override
	public String toString() {
		return "Question_Comments [author=" + author + ", comment_contents=" + comment_contents + ", comment_number="
				+ comment_number + ", question_number=" + question_number + "]";
	}
	public Question_Comments(String author, String comment_contents, int comment_number, int question_number) {
		super();
		this.author = author;
		this.comment_contents = comment_contents;
		this.comment_number = comment_number;
		this.question_number = question_number;
	}
	public Question_Comments() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	
	
}
