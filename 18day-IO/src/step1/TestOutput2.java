package step1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TestOutput2 {

	public static void main(String[] args) {
		String path = "C:\\java-kosta\\test\\���ɸ޴�.txt";
		try {
			FileWriter fw = new FileWriter(path);
			PrintWriter pw = new PrintWriter(fw, true);// true: autoflush
			Scanner sc = new Scanner(System.in);
			System.out.println("**���ɸ޴�**");
			while (true) {
				String input = sc.nextLine();
				if (input.equals("�ֹ���")) {
					System.out.println("�ֹ��� �Ϸ�Ǿ����ϴ�!");
					break;
				}
				pw.println(input);
				System.out.println(input + " �ֹ�!");
			}
			pw.close();
			sc.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
