package step2;

public class House {
	private String address;
	private int price;
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setAddress(String address){
		// this keyword�� �̿��� instance variable�� ����Ų��.
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
}
