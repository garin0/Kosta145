package model;

public class HomeAppliance {
	private String maker;
	private String productName;
	
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	@Override
	public String toString() {
		return "HomeAppliance [maker=" + maker + ", productName=" + productName + "]";
	}
	
}
