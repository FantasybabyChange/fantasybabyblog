package com.fantasybabymg.ubean;

import java.util.List;
/**
 * 分页对象
 * @author FantasyBaby
 *
 * @param <T>
 */
public class Pager<T> {
	/**
	 * 当前页书
	 */
	private int pageIndex;
	
	/**
	 * 总条数
	 */
	private int totalRecord;
	/**
	 * 共多少页
	 */
	private int totalPage;
	
	private List<T> datas;

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord,int pageSize) {
		//得到总页数
		this.totalPage = (totalRecord + pageSize -1) / pageSize;
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		return this.totalPage;
	}
	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

}
