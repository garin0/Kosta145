package step5;

public class Account {
	// private ���������ڷ� �ܺ���������
	private int money;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	// public setter/getter�� ���������ϰ� �Ѵ�.
	// setter method : �ܺο��� ������ �Ҵ��Ҷ� ����Ѵ�.
	public void setMoney(int m){
		money = m;
	}
	// getter method : �ܺη� ������ ������ �� ���
	public int getMoney() {
		return money;
	}
}
