package step6;

public class Account {
	private int balance;

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		if(balance < 1){
			System.out.println("�߸��� �ݾ��Դϴ�.");
		}
		else{
			this.balance = balance;
		}
	}

	public void deposit(int balance) {
		if(balance < 0){
			System.out.println("�߸��� �ݾ��Դϴ�.");
		}else{
			this.balance += balance;
		}
	}

	public void withdraw(int balance) {
		if(balance <= 0){
			System.out.println("�߸��� �ݾ��Դϴ�.");
		}else if(this.balance < balance){
			System.out.println("�ܾ��� �����մϴ�.");
		}else{
			this.balance -= balance;
		}
	}
	
}
