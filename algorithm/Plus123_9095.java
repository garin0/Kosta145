import java.util.Scanner;

public class Plus123_9095 {
	/*
	 * 9095.1, 2, 3 더하기
	 * dp로 풀음
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();

		int[] dp = new int[11];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i < 11; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		for (int i = 0; i < testcase; i++) {
			int n = sc.nextInt();
			System.out.println(dp[n]);
		}

	}

}
