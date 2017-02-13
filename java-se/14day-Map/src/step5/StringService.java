package step5;

import java.util.ArrayList;

public class StringService {
	private ArrayList<String> list = new ArrayList<String>();

	public void addFile(String title) {
		list.add(title);
	}

	public void printName(String ext) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).endsWith(ext)) {
				System.out.println(list.get(i).replace("." + ext, ""));
//				System.out.println(list.get(i).substring(0, list.get(i).lastIndexOf(".")));
			}
		}
	}

}
