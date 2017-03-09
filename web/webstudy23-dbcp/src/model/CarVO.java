package model;

public class CarVO {
	private String no;
	private String model;
	private int price;
	public CarVO(String no, String model, int price) {
		super();
		this.no = no;
		this.model = model;
		this.price = price;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
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
