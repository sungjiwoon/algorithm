package b_15_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 240118 백준 포도주 시식 (실버 1)
 * DP
 */
public class B_2156 {
	int n;
	int[] info;

	private int solve() {
		int[] dp = new int[10001];

		dp[1] = info[1];
		if (n >= 2) dp[2] = info[2] + info[1];
		if (n >= 3) dp[3] = Math.max(Math.max(info[1], info[2]) + info[3], dp[2]);

		for (int i = 4; i <= n; i++) {
			dp[i] = Math.max(dp[i-3] + info[i-1], dp[i-2]) + info[i];
			dp[i] = Math.max(dp[i-1], dp[i]);
		}

		return dp[n];
	}


	public static void main(String[] args) {
		B_2156 m = new B_2156();

//		Main m = new Main();

		m.init();
		System.out.println(m.solve());

	}

	private void init() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			n = Integer.parseInt(br.readLine());
			info = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				info[i] = Integer.parseInt(br.readLine());
			}

		} catch (Exception e) {}
	}

}
