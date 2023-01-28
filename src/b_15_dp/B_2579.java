package b_15_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2579 {
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = arr[1];
		for (int i = 2; i <= n; i++) {
			dp[i] = Math.max(dp[i-1]+arr[i], dp[i-2]+arr[i]);
		}
		System.out.println(dp[n]);
	}
}
