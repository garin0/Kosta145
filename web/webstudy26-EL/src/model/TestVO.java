package model;

public class TestVO {
	public String getName(){
		System.out.println("getName() 실행");
		return "김호겸";
	}
	public String findNick(){
		return "야탑 정준영";
	}
	
	public String getNickName(){
		return "야탑 정준영";
	}
	public boolean isFile(){
		return false;
	}
	public int getMoney(){
		return 100;
	}
}
