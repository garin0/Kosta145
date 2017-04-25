package model;

public class ItemVO {
	private String name;
	private String maker;
	private int price;
	private String detail;
	public ItemVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemVO(String name, String maker, int price,String detail) {
		this.name = name;
		this.maker = maker;
		this.price = price;
		this.detail = detail;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	@Override
	public String toString() {
		return "ItemVO [name=" + name + ", maker=" + maker + ", price=" + price + ", detail=" + detail + "]";
	}
	
	
}
