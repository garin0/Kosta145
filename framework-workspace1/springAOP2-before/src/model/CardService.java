package model;

public class CardService {
	public void register(int no){
		System.out.println("카드 등록: "+no);
	}
	public void pay(){
		System.out.println("카드 결제");
	}
	public void delete(int no){
		System.out.println("카드 해약:"+no);
	}
}
