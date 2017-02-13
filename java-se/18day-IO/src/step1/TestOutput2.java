package step1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TestOutput2 {

	public static void main(String[] args) {
		String path = "C:\\java-kosta\\test\\점심메뉴.txt";
		try {
			FileWriter fw = new FileWriter(path);
			PrintWriter pw = new PrintWriter(fw, true);// true: autoflush
			Scanner sc = new Scanner(System.in);
			System.out.println("**점심메뉴**");
			while (true) {
				String input = sc.nextLine();
				if (input.equals("주문끝")) {
					System.out.println("주문이 완료되었습니다!");
					break;
				}
				pw.println(input);
				System.out.println(input + " 주문!");
			}
			pw.close();
			sc.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
