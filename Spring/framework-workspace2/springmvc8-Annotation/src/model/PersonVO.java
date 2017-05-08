package model;

import java.util.ArrayList;

public class PersonVO {
	private String id;
	private String name;
	private CarVO carVO;
	private ArrayList<String> menu;
	public PersonVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PersonVO(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public ArrayList<String> getMenu() {
		return menu;
	}
	public void setMenu(ArrayList<String> menu) {
		this.menu = menu;
	}
	public CarVO getCarVO() {
		return carVO;
	}
	public void setCarVO(CarVO carVO) {
		this.carVO = carVO;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "PersonVO [id=" + id + ", name=" + name + ", carVO=" + carVO + ", menu=" + menu + "]";
	}
	
	
}
