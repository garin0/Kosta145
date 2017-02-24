package model;

public class ItemVO {
	private int item_no;
	private String name;
	private String maker;
	private int price;
	public ItemVO(String name, String maker, int price) {
		this.name = name;
		this.maker = maker;
		this.price = price;
	}

	public ItemVO(int item_no,String name) {
		this.item_no = item_no;
		this.name =name;
	}
	public ItemVO(int item_no,String name, String maker, int price){
		this.item_no = item_no;
		this.name = name;
		this.maker = maker;
		this.price = price;
	}
	public int getItem_no() {
		return item_no;
	}
	public void setItem_no(int item_no) {
		this.item_no = item_no;
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
}
