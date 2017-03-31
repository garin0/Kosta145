package model;

import java.util.ArrayList;

public class ListVO {
	private ArrayList<BoardVO> list;
	private PagingBean pagingbean;
	private static ListVO vo = new ListVO();
	public ListVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static ListVO getInstance(){		
		return vo;
	}
	public ListVO(ArrayList<BoardVO> list, PagingBean pagingbean) {
		super();
		this.list = list;
		this.pagingbean = pagingbean;
	}
	
	public ArrayList<BoardVO> getList() {
		return list;
	}
	public void setList(ArrayList<BoardVO> list) {
		this.list = list;
	}
	public PagingBean getPagingbean() {
		return pagingbean;
	}
	public void setPagingbean(PagingBean pagingbean) {
		this.pagingbean = pagingbean;
	}
	@Override
	public String toString() {
		return "ListVO [list=" + list + ", pagingbean=" + pagingbean + "]";
	}
	
}
