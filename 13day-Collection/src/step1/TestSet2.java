package step1;

import java.util.LinkedHashSet;
import java.util.TreeSet;

public class TestSet2 {

	public static void main(String[] args) {
		// Set 계열 TreeSet class에 generic 적용하는 예제
		// 아래 set에는 String 타입의 요소만 추가될 수 있도록 generic을 적용
		TreeSet<String> set = new TreeSet<String>();
		set.add("김래현");
		set.add("신용혁");
		// set.add(1); //컴파일 에러, String 타입만 가능하게 generic 선언
		set.add("하현우");
		set.add("신용혁"); // 중복 허용 X
		System.out.println(set);
		System.out.println("**********");
		LinkedHashSet<String> hs = new LinkedHashSet<String>();
		hs.add("A");
		hs.add("D");
		hs.add("B");
		hs.add("A"); // 중복되어 추가되지 않는다.
		System.out.println(hs); // 추가된 순서를 기억하여 A D B가 출력
	}

}
