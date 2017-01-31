package step6;

abstract class Parent {
	public void eat() {
		System.out.println("eat!");
	}

	/*
	 * abstract method : ������ ���� ���� �Ѵ�. �ڽ� Ŭ�������� ������ ���� abstract method�� �ϳ� �̻�
	 * �����ϸ� �� Ŭ������ abstract class�� ����Ǿ�� �Ѵ�. abstract class�� ���� ��üȭ �� �� ����.
	 */
	public abstract void study();

}

class Child extends Parent {
	/*
	 * �θ� Ŭ������ abstract method�� �ݵ�� �����ؾ�
	 * ��ü ���� ������ �ڽ� Ŭ������ �� �� �ִ�.
	 */
	@Override
	public void study() {
		System.out.println("study!!");
	}

}

public class TestAbstract1 {

	public static void main(String[] args) {
		// error: abstract class�̹Ƿ� ���� ��üȭ �� �� ����.
		// new Parent();
		Child c = new Child();
		c.eat();
		c.study();
	}

}
