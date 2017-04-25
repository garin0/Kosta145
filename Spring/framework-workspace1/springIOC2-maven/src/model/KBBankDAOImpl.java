package model;

public class KBBankDAOImpl implements BankDAO {

	@Override
	public void deposit(int money) {
		System.out.println("국민은행 "+money+"원 입금처리");
	}

}
