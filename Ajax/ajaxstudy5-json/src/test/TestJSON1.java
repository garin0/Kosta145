package test;

import org.json.JSONObject;

import model.MemberVO;

public class TestJSON1 {

	public static void main(String[] args) {
		JSONObject json1 = new JSONObject();
		json1.put("name", "아이유");
		json1.put("address", "판교");
		System.out.println(json1.toString());
		MemberVO vo = new MemberVO("java",null,"김문일","판교");
		//vo 객체를 json object로 만들때는 생성자를 이용
		JSONObject json2 = new JSONObject(vo);
		System.out.println(json2.toString());
	}

}
