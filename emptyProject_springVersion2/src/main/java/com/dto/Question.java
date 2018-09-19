package com.dto;

public class Question {

	private String question_num;
	private String title; 
	private String question_contents; 
	private String userid;
	private String writeday;
	private String image_name;
	public String getQuestion_num() {
		return question_num;
	}
	public void setQuestion_num(String question_num) {
		this.question_num = question_num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getQuestion_contents() {
		return question_contents;
	}
	public void setQuestion_contents(String question_contents) {
		this.question_contents = question_contents;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getWriteday() {
		return writeday;
	}
	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}
	public String getImage_name() {
		return image_name;
	}
	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}
	@Override
	public String toString() {
		return "Question [question_num=" + question_num + ", title=" + title + ", question_contents="
				+ question_contents + ", userid=" + userid + ", writeday=" + writeday + ", image_name=" + image_name
				+ "]";
	}
	public Question(String question_num, String title, String question_contents, String userid, String writeday,
			String image_name) {
		super();
		this.question_num = question_num;
		this.title = title;
		this.question_contents = question_contents;
		this.userid = userid;
		this.writeday = writeday;
		this.image_name = image_name;
	}
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
}
