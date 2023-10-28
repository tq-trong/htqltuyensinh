package com.cusc.htqltuyensinh.api.output;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractOutput<T> {
	private int page;
	private int totalPage;
	private List<T> listResult = new ArrayList<>();
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getListResult() {
		return listResult;
	}
	public void setListResult(List<T> listResult) {
		this.listResult = listResult;
	}
	
	public int setTotalPage(long totalItems, long limit) {
		return (int) Math.ceil((double) totalItems / limit);
	}
}
