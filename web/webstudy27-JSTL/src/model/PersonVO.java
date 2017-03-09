package model;

public class PersonVO {
	private String name;
	private int money;
	public PersonVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PersonVO(String name, int money) {
		super();
		this.name = name;
		this.money = money;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "PersonVO [name=" + name + ", money=" + money + "]";
	}
	
}
