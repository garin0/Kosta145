package model;

public class AccountService {
	public void deposit(int money){
		System.out.println("입금처리 "+money);
	}
	public void withdraw(int money){
		System.out.println("출금처리 "+money);
	}
	public void register(String name,int money){
		System.out.println("계좌 등록:"+name+" "+money);
	}
}
