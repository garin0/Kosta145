package test;

import org.json.JSONArray;

public class TestJSON2 {

	public static void main(String[] args) {
		// JSONArray test
		JSONArray ja = new JSONArray();
		ja.put("김성환");
		ja.put("임경수");
		ja.put("이상섭");
		ja.put("김규익");
		System.out.println(ja.toString());
	}
}
