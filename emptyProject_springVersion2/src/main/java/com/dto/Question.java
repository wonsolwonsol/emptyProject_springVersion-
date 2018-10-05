package com.dto;

import org.apache.ibatis.type.Alias;

@Alias("Question")
public class Question {

	private int question_number;
	private String title;
	private String author;
	private String content;
	private String regdate;
	public int getQuestion_number() {
		return question_number;
	}
	public void setQuestion_number(int question_number) {
		this.question_number = question_number;
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
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "Question [question_number=" + question_number + ", title=" + title + ", author=" + author + ", content="
				+ content + ", regdate=" + regdate + "]";
	}
	public Question(int question_number, String title, String author, String content, String regdate) {
		super();
		this.question_number = question_number;
		this.title = title;
		this.author = author;
		this.content = content;
		this.regdate = regdate;
	}
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
