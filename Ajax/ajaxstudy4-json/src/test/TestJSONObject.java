package test;

import org.json.JSONObject;

import model.CarDTO;

public class TestJSONObject {
	public static void main(String[] args) {
		JSONObject obj = new JSONObject();
		obj.put("id", "java");
		System.out.println(obj.toString());
		CarDTO dto = new CarDTO("소나타", 100);
		JSONObject jsonObj = new JSONObject(dto);
		System.out.println(jsonObj.toString());
	}
}
