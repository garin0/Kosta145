package step3;

import java.io.IOException;
import java.util.ArrayList;

public class TestIOService {

	public static void main(String[] args) {
		String path = "C:\\java-kosta\\test\\iotest\\list.txt";
		IOService service = new IOService(path);
		ArrayList<String> list = new ArrayList<String>();
		list.add("조인성");
		list.add("정우성");
		list.add("김아중");
		list.add("설현");
		try{
			service.writeList(list);
			System.out.println(path+ " 저장완료");
		}catch(IOException ie){
			ie.printStackTrace();
		}
	}

}
