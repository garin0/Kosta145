package step7;
class Person{
	public void eat(){
		System.out.println("�Դ�");
	}
	//�޼��� �����ε�
	public void eat(String menu){
		System.out.println(menu+" �Դ�");
	}
	public void eat(int count){
		System.out.println(count+ "�κ� �Դ�.");
	}
	public void eat(String menu, int count){
		System.out.println(menu+" "+count+ "�κ� �Դ�.");
	}
}
public class TestMethodOverLoading {

	public static void main(String[] args) {
		Person p = new Person();
		p.eat();
		p.eat("����");
		p.eat(1);
		p.eat("����", 2);
	}

}
