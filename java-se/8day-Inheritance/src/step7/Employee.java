package step7;

public class Employee {
	private String name;

	public Employee(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	private int salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
}
