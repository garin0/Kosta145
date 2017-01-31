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
		// 위 메서드를 호출하면 error가 발생
		// 이 경우 프로그램을 수정하거나 환경을 변경해야 한다.
	}

}
