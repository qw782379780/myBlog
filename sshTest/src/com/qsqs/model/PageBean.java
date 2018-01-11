package com.qsqs.model;

import java.util.ArrayList;

public class PageBean<T> {
    //总个数
	private Integer totalCount;
	//总页数
	private Integer totalPage;
	//每页页数
	private Integer pageSize;
	//当前页码
	private Integer currentPage;
	//article对象集合
    private ArrayList<T> beanlist;
    
	public PageBean(){};
	
	public PageBean(Integer totalCount, Integer totalPage, Integer pageSize,
			Integer currentPage, ArrayList<T> beanlist) {
		super();
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.beanlist = beanlist;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	
	public Integer getTotalPage() {
		return (int) Math.ceil((totalCount*1.0)/pageSize);
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public ArrayList<T> getBeanlist() {
		return beanlist;
	}

	public void setBeanlist(ArrayList<T> beanlist) {
		this.beanlist = beanlist;
	}

}
