package model;

import java.util.ArrayList;

public class ListVO {
	private ArrayList<CarVO> carList;
	private PagingBean pagingbean;
	public ListVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ListVO(ArrayList<CarVO> carList, PagingBean pagingbean) {
		super();
		this.carList = carList;
		this.pagingbean = pagingbean;
	}
	public ArrayList<CarVO> getCarList() {
		return carList;
	}
	public void setCarList(ArrayList<CarVO> carList) {
		this.carList = carList;
	}
	public PagingBean getPagingbean() {
		return pagingbean;
	}
	public void setPagingbean(PagingBean pagingbean) {
		this.pagingbean = pagingbean;
	}
	@Override
	public String toString() {
		return "ListVO [carList=" + carList + ", pagingbean=" + pagingbean + "]";
	}
	
	
}
