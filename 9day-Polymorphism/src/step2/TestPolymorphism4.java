package step2;

class Employee { // extends Object
	public void calSalary() {
		System.out.println("�Ϲ� ��� ���ް��");
	}
}

class Manager extends Employee {
	@Override
	public void calSalary() {
		System.out.println("�Ŵ��� ���� ���");
	}
}

class Engineer extends Employee {
	@Override
	public void calSalary() {
		System.out.println("�����Ͼ� ���� ���");
	}
}
class HRService{
	// ���� �θ�Ÿ���� ������ �پ��� ��ü�� ó���Ѵ�.
	public void process(Employee employee){ 
		// �������̵��� �޼��带 ȣ���ϸ� �پ��� ��ü���� ������ ������� �����Ѵ�.
		employee.calSalary();
	}
}
public class TestPolymorphism4 {

	public static void main(String[] args) {
		HRService service = new HRService();
		service.process(new Manager());
		service.process(new Engineer());
		service.process(new Employee());
	}

}
