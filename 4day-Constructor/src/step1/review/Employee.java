package step1.review;//패키지 : 디렉토리별로 클래스 분류 
//클래스 선언 : 객체 생성을 위한 틀
public class Employee {
	//private으로 외부(다른 클래스 or 다른패키지)의 접근을 차단
	//변수(variable or instance variable or member variable)
	//객체의 속성 정보를 저장
	private String name;
	private int age; //멤버변수 or 인스턴스 변수 
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	//메서드
	public void setName(String name) { // 매개변수 or 지역변수 
		this.name = name;
	}
	
}
