package step1;

public class TestWrapper {

	public static void main(String[] args) {
		int i = 1;
		Object obj = i; // autoboxing(�ڵ����� Wrapper class Integer ��ü�� ��ȯ)
		System.out.println(obj.getClass()); // class.java.lang.Integer
		int j = (Integer) obj; // auto unboxing(�ڵ����� Wrapper class ���������� �⺻������
								// ��ȯ)
		System.out.println(j);
	}

}
