package model;

public class Bat {
	private String maker;
	private int price;
	public Bat(String maker, int price) {
		super();
		this.maker = maker;
		this.price = price;
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
	@Override
	public String toString() {
		return "Bat [maker=" + maker + ", price=" + price + "]";
	}
	
}
