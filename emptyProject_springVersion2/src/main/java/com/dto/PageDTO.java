package com.dto;

import java.util.List;

public class PageDTO {
	List<Goods> list;
	int currentPage;
	int perPage = 10;
	int totalCount;
	public List<Goods> getList() {
		return list;
	}
	public void setList(List<Goods> list) {
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
		return "PageDTO [list=" + list + ", currentPage=" + currentPage + ", perPage=" + perPage + ", totalCount="
				+ totalCount + "]";
	}
	public PageDTO(List<Goods> list, int currentPage, int perPage, int totalCount) {
		super();
		this.list = list;
		this.currentPage = currentPage;
		this.perPage = perPage;
		this.totalCount = totalCount;
	}
	public PageDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}