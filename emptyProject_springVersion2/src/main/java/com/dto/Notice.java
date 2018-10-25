package com.dto;

import org.apache.ibatis.type.Alias;

@Alias("Notice")
public class Notice {

	
	private int seq;
	private String title;
	private String content;
	private String reg_dts;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
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
	public String getReg_dts() {
		return reg_dts;
	}
	public void setReg_dts(String reg_dts) {
		this.reg_dts = reg_dts;
	}
	@Override
	public String toString() {
		return "Notice [seq=" + seq + ", title=" + title + ", content=" + content + ", reg_dts=" + reg_dts + "]";
	}
	public Notice(int seq, String title, String content, String reg_dts) {
		super();
		this.seq = seq;
		this.title = title;
		this.content = content;
		this.reg_dts = reg_dts;
	}
	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
}
