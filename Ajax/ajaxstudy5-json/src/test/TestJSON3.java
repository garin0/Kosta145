package test;

import java.util.ArrayList;

import org.json.JSONArray;

import model.CarDTO;

public class TestJSON3 {

	public static void main(String[] args) {
		ArrayList<CarDTO> list = new ArrayList<CarDTO>();
		list.add(new CarDTO("sm5", 500));
		list.add(new CarDTO("k7", 700));
		list.add(new CarDTO("bmw", 900));
		// list 를 JSONArray로 생성
		JSONArray arr = new JSONArray(list);
		System.out.println(arr.toString());
		/* JSONArray 안에 JSONObject 3개로 구성된다.
		 * [{"price":500,"model":"sm5"},{"price":700,"model":"k7"},{"price":900,"model":"bmw"}]
		 * client javascript에서는 
		 * var carList = JSON.parse(xhr.responseText);
		 * alert(carList[0].model); // SM5
		 */
	}

}
