package org.kosta.springmvc12.model;

public class CarVO {
	private int no;
	private String model;
	private int price;
	public CarVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CarVO(int no, String model, int price) {
		super();
		this.no = no;
		this.model = model;
		this.price = price;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "CarVO [no=" + no + ", model=" + model + ", price=" + price + "]";
	}
	
}
