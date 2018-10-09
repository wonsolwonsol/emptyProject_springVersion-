package com.dto;

import java.util.List;

import org.apache.ibatis.type.Alias;
//QuestionBoard 용 Page
@Alias("Page2")
public class Page2 {
	List<Question> list;
	int currentPage;
	int perPage = 8;
	int totalCount;
	public List<Question> getList() {
		return list;
	}
	public void setList(List<Question> list) {
		this.list = list;
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
		return "Page2 [list=" + list + ", currentPage=" + currentPage + ", perPage=" + perPage + ", totalCount="
				+ totalCount + "]";
	}
	public Page2(List<Question> list, int currentPage, int perPage, int totalCount) {
		super();
		this.list = list;
		this.currentPage = currentPage;
		this.perPage = perPage;
		this.totalCount = totalCount;
	}
	public Page2() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
