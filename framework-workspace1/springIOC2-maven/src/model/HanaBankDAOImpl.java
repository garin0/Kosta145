package model;

public class HanaBankDAOImpl implements BankDAO {
	@Override
	public void deposit(int money) {
		System.out.println("하나은행 " + money + "원 입금처리");
	}
}
