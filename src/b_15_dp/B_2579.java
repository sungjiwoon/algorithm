package b_15_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2579 {
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int n = Integer.parseInt(br.readLine());
		
		int[] map = new int[n+1];
		long[] dp = new long[n+1];
		
		for (int i = 1; i <= n; i++) map[i] = Integer.parseInt(br.readLine());
		
		//i-1번째 계단을 밟지 않을 때의 최댓값. 
		
		dp[1] = map[1];
		if (n >= 2) {
			dp[2] = map[1] + map[2];
		}
		
		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i-2], dp[i-3]+map[i-1]) +  map[i];	
		}
		
		System.out.println(dp[n]);
	}
}
