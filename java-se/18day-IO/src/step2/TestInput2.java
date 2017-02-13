package step2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestInput2 {

	public static void main(String[] args) {
		String file = "C:\\java-kosta\\test\\���μ�.txt";
		// �� ���Ͽ� �ִ� ������ ��� �о �ֿܼ� ����Ѵ�.
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String str = br.readLine();
			while(str!=null){
				System.out.println(str);
				str = br.readLine();
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
