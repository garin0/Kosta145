package step2;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class TestVariableScope {
	private int i; // instance v : heap 영역 저장, 기본 초기화 0

	public void test1() {
		int j; // local v
		System.out.println(i); // 기본초기화 되어 0 출력
		// System.out.println(j); //error , j는 지역변수이므로 초기화 필요
		int k = 0;
		System.out.println(k);
	}

	public void test2(int i) {
		System.out.println(i); // 지역변수 i
		System.out.println(this.i); // instance 변수
		int j = 2;
	}

	public void test3() {
		System.out.println(i); // instance v 이므로 사용가능
		// System.out.println(j); //지역변수이므로 test2()내에서만 사용가능
	}

	public void test4() {
		if (i <= 0) {
			int k = 5;
		}
		// System.out.println(k); //지역변수 k는
		// 선언된 자신의 실행역역 내에서만 사용가능
		// test5()에서 코드를 변경해본다.
	}

	public void test5() {
		int k = 0;
		if (i <= 0) {
			k = 5;
		}
		System.out.println(k);
	}

	public static void main(String[] args) {
		// 메인메서드는 static 이므로 같은 클래스의 메서드라도
		// 객체를 생성해서 호출해야 한다. (static은 다음주)
		TestVariableScope t = new TestVariableScope();
		t.test1();
		t.test5();
	}
}
