package model;

public interface AccountService {

	void deposit(int money);

	void withdraw(int money);

	void register(String name, int money);

}