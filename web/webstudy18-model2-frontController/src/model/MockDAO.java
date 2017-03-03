package model;

import java.util.ArrayList;

// DAO는 실제 db와 연동하지 않는다.
public class MockDAO {
	private static MockDAO instance = new MockDAO();
	private MockDAO(){}
	public static MockDAO getInstance(){
		return instance;
	}
	public String findById(String id){
		String result = null;
		if(id.equals("java"))
			result ="아이유 판교";
		return result;
	}
	public void insert(String name,String address){
		System.out.println(name+" "+address+" db insert");
	}
	public ArrayList<String> findByAddress(String address){
		ArrayList<String> list = new ArrayList<String>();
		if(address.equals("판교")){
			list.add("정석희");
			list.add("강정호");
			list.add("오남준");
		}
		return list;
	}
	
	public void updateNick(String nick){
		System.out.println(nick+" 닉네임 db 정보 수정");
	}
}
