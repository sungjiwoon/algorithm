package b_15_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1904 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[1000001];

		// 현재 길이가 짝수 일 경우 전 단계 가짓수 그대로 가져감. 1 -> 11,

		// 1 / 00 11 / 001 100 111
		// 0011 1001 1111 0000 1100 (5)
		// 00111 10011 11111 00001 11001 00100 10000 11100 (5 + 3)

		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
			dp[i] %= 15746;
		}

		System.out.println(dp[n]);
	}
}
