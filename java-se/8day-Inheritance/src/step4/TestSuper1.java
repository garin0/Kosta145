package step4;

class A{ //extends Object(���߿� ����)
	A(){
		System.out.println("A ��ü ����");
	}
}
class B extends A{
	B(){
		System.out.println("B ��ü ����");
	}
}
class C extends B{
	C(){
		System.out.println("C ��ü ����");
	}
}

public class TestSuper1 {

	public static void main(String[] args) {
		new C();
		// A -> B - > C ������ ��ü �����ȴ�.
		// �����ڿ� super()�� ��õǾ� ���� ������ �����Ͻ� ���Եȴ�.
		
	}

}
