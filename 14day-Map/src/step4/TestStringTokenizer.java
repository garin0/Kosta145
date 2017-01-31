package step4;

import java.util.StringTokenizer;

public class TestStringTokenizer {

	public static void main(String[] args) {
		String str1 = "���� �� ���� ��������";
		// ������ �������� ���ڿ��� �ڸ���.
		StringTokenizer st = new StringTokenizer(str1);
		while(st.hasMoreTokens()){
			System.out.println(st.nextToken());
		}
		System.out.println("------------------");
		String str2="������ũ,����,ġ��,����,�Ŷ��,����,ġŲ";
		// , Ư�� �����ڸ� �߽����� ���ڿ��� �ڸ���.
		StringTokenizer stk = new StringTokenizer(str2, ",");
		while(stk.hasMoreTokens()){
			System.out.println(stk.nextToken());
		}
	}

}
