package step1.vo;

public class Person {
	private String name; // instance variable
	private int age; // instance variable
	//Constructor
	public Person(String name, int age) { //local variable ( parameter )
		this.name = name;
		this.age = age;
	}

	public String getName() { // method getter ���� ��ȯ 
		return name;
	}

	public void setName(String name) { //method setter ���� �Ҵ� 
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
