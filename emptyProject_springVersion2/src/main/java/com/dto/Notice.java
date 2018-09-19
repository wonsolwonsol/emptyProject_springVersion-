package com.dto;

public class Notice {

	
	private int seq;
	private String title;
	private String content;
	private String dreg_dts;
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
	public String getDreg_dts() {
		return dreg_dts;
	}
	public void setDreg_dts(String dreg_dts) {
		this.dreg_dts = dreg_dts;
	}
	@Override
	public String toString() {
		return "Notice [seq=" + seq + ", title=" + title + ", content=" + content + ", dreg_dts=" + dreg_dts + "]";
	}
	public Notice(int seq, String title, String content, String dreg_dts) {
		super();
		this.seq = seq;
		this.title = title;
		this.content = content;
		this.dreg_dts = dreg_dts;
	}
	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
