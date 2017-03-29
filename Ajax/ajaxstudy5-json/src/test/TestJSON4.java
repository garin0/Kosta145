package test;

import java.util.HashMap;

import org.json.JSONObject;

public class TestJSON4 {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("deptNo","10");
		map.put("dname","영업");
		map.put("location", "판교");
		JSONObject json = new JSONObject(map);
		System.out.println(json.toString());
	}

}
