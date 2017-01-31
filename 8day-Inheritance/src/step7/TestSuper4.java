package step7;

public class TestSuper4 {

	public static void main(String[] args) {
		Employee e = new Employee("배수지", 300);
		System.out.println(e.getName() + " " + e.getSalary());
		Manager m = new Manager("유재석", 500, "영업부");
		System.out.println(m.getName() + " " + m.getSalary() + " " + m.getDepartment());
	}

}
