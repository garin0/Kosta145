package step2;
class ErrorEX {
	public void a(){
		System.out.println("a method exe");
		b();
	}
	public void b(){
		System.out.println("b method exe");
		a();
	}
	
}
public class TestError {

	public static void main(String[] args) {
		ErrorEX ex = new ErrorEX();
		ex.a();
		// �� �޼��带 ȣ���ϸ� error�� �߻�
		// �� ��� ���α׷��� �����ϰų� ȯ���� �����ؾ� �Ѵ�.
	}

}
