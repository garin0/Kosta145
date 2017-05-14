package org.kosta.springmvc15.model.aop;

public class ReportVO {
	private String keyword;
	private int count;
	private int rk;
	public ReportVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ReportVO(String keyword) {
		super();
		this.keyword = keyword;
	}

	public ReportVO(String keyword, int count) {
		super();
		this.keyword = keyword;
		this.count = count;
	}
	
	public ReportVO(String keyword, int count, int rk) {
		super();
		this.keyword = keyword;
		this.count = count;
		this.rk = rk;
	}

	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public int getRk() {
		return rk;
	}

	public void setRk(int rk) {
		this.rk = rk;
	}

	@Override
	public String toString() {
		return "ReportVO [keyword=" + keyword + ", count=" + count + "]";
	}
	
}
