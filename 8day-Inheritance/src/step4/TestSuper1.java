package step4;

class A{ //extends Object(나중에 공부)
	A(){
		System.out.println("A 객체 생성");
	}
}
class B extends A{
	B(){
		System.out.println("B 객체 생성");
	}
}
class C extends B{
	C(){
		System.out.println("C 객체 생성");
	}
}

public class TestSuper1 {

	public static void main(String[] args) {
		new C();
		// A -> B - > C 순서로 객체 생성된다.
		// 생성자에 super()가 명시되어 있지 않으면 컴파일시 삽입된다.
		
	}

}
