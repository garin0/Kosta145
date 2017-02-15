package model;

public class AccountLoginException extends Exception{
	// 계좌 없을 때
	private static final long serialVersionUID = -3681249781517219295L;
	
	public AccountLoginException(String message){
		super(message);
	}
}
