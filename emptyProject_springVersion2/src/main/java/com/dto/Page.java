package com.dto;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("Page")
public class Page {
	List<Goods> list;
	List<Notice> list2; 
	List<Question> Qlist; 
	int currentPage;
	int perPage = 8;
	int totalCount;
	public List<Goods> getList() {
		return list;
	}
	public void setList(List<Goods> list) {
		this.list = list;
	}
	
	public List<Question> getQlist() {
		return Qlist;
	}
	public void setQlist(List<Question> Qlist) {
		this.Qlist = Qlist;
	}
	public void setList2(List<Notice> list2) {
		this.list2=list2; 
	}
	public List<Notice> getList2(){
		return list2 ; 
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	@Override
	public String toString() {
		return "PageDTO [list=" + list + ", list2" + list2 + ", Qlist" + Qlist + ", currentPage=" + currentPage + ", perPage=" + perPage + ", totalCount="
				+ totalCount + "]";
	}
	public Page(List<Goods> list, List<Notice> list2, int currentPage, int perPage, int totalCount) {
		super();
		this.list = list;
		this.list2 = list2;
		this.Qlist = Qlist;
		this.currentPage = currentPage;
		this.perPage = perPage;
		this.totalCount = totalCount;
	}
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
