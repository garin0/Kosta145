package model;

public class ProductVO {
	private int productNO;
	private String name;
	private String maker;
	private int price;
	private String date;
	
	public ProductVO(int productNO, String name, String maker, int price, String date) {
		super();
		this.productNO = productNO;
		this.name = name;
		this.maker = maker;
		this.price = price;
		this.date = date;
	}
	public ProductVO(String name, String maker, int price) {
		super();
		this.name = name;
		this.maker = maker;
		this.price = price;
	}
	public ProductVO(int productNO, String name, String date) {
		super();
		this.productNO = productNO;
		this.name = name;
		this.date = date;
	}
	public int getProductNO() {
		return productNO;
	}
	public void setProductNO(int productNO) {
		this.productNO = productNO;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "ProductVO [productNO=" + productNO + ", name=" + name + ", maker=" + maker + ", price=" + price
				+ ", date=" + date + "]";
	}

	
}
