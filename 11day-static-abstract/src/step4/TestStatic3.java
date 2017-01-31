package step4;

class Car {
	int count; // �ν��Ͻ� ����: heap ���� ���� , ��ü �����ø��� ���� ������ ����
	static int sCount; // class variable : method area ���� ����, class loading�ÿ� �ѹ�
						// ���� �����Ǿ� ����.

	Car() {
		count++;
		sCount++;
	}
}

/*
 * �ν��Ͻ� ���� ������ static ���� ������ ����� �
 * ���̸� ���̴� ���� ���� ����
 */
public class TestStatic3 {

	public static void main(String[] args) {
		Car c1 = new Car();
		System.out.println(c1.count); // 1
		System.out.println(Car.sCount); // 1
		Car c2 = new Car();
		System.out.println(c2.count); // 1
		System.out.println(Car.sCount); // 2
		Car c3 = new Car();
		System.out.println(c3.count); // 1
		System.out.println(Car.sCount); // 3
	}

}
