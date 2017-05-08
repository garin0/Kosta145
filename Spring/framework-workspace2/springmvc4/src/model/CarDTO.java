package model;
/*
 * VO:Value Object
 * DTO : Data Transfer Object
 * DAO : Data Access Object
 * Service : Business Object
 */
public class CarDTO {
	private String model;
	private int price;
	public CarDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CarDTO(String model, int price) {
		super();
		this.model = model;
		this.price = price;
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
		return "CarDTO [model=" + model + ", price=" + price + "]";
	}
	
}
