package step1.review;//��Ű�� : ���丮���� Ŭ���� �з� 
//Ŭ���� ���� : ��ü ������ ���� Ʋ
public class Employee {
	//private���� �ܺ�(�ٸ� Ŭ���� or �ٸ���Ű��)�� ������ ����
	//����(variable or instance variable or member variable)
	//��ü�� �Ӽ� ������ ����
	private String name;
	private int age; //������� or �ν��Ͻ� ���� 
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	//�޼���
	public void setName(String name) { // �Ű����� or �������� 
		this.name = name;
	}
	
}
