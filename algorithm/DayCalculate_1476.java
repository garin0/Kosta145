import java.util.Scanner;

public class DayCalculate_1476 {
	/*
	 * BOJ.1476
	 * --> 중국인의 나머지 정리를 이용한다.
	 * (7*e)%15==1 e=13
	 * (5*s)%28==1 s=17
	 * (2*m)%19==1 m=10
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int E, S, M, result;
		E = sc.nextInt();
		S = sc.nextInt();
		M = sc.nextInt();
		result = (E * 6916 + S * 4845 + M * 4200) % (7980);
		if(result == 0)
			result = 7980;
		System.out.println(result);
	}

}
