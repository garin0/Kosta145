package step2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestInput {

	public static void main(String[] args) {

		try {
			// ���Ͽ� ����Ǵ� �Է� ��� ��Ʈ��
			FileReader fr = new FileReader("C://java-kosta//test//���ɸ޴�.txt");
			// �Է� ���μ��� ��Ʈ��
			BufferedReader br = new BufferedReader(fr);
			// �Ѷ��ξ� �Է¹޾ƺ���.
			// ���̻� �Է¹��� ������ ������ null ��ȯ
			System.out.println(br.readLine());
			br.close();
			System.out.println("�Է��۾� �Ϸ�");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
