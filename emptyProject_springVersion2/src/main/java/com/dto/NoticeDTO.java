package com.dto;

import java.util.List;

public class NoticeDTO {

	private String seq; 
	private String title;
	private String content; 
	private String reg_dts;
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
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
	public void setReg_des(String reg_dts) {
		this.reg_dts = reg_dts;
	}
	@Override
	public String toString() {
		return "NoticeDTO [seq=" + seq + ", title=" + title + ", content=" + content + ", reg_dts=" + reg_dts + "]";
	}
	public NoticeDTO(String seq, String title, String content, String reg_dts) {
		super();
		this.seq = seq;
		this.title = title;
		this.content = content;
		this.reg_dts = reg_dts;
	}
	public NoticeDTO() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	
	
	
		}

