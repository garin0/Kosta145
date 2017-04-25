package model;

public class Person {
	private String name;
	private int age;
	private Bat bat;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Bat getBat() {
		return bat;
	}
	public void setBat(Bat bat) {
		this.bat = bat;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", bat=" + bat + "]";
	}
	
	
}
