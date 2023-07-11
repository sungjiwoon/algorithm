package b_15_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2156 {
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int n = Integer.parseInt(br.readLine());
		
		int[] map = new int[n+1];
		long[] dp = new long[n+1];
		
		for (int i = 1; i <= n; i++) map[i] = Integer.parseInt(br.readLine());
		
		//3ÀÜ ¿¬¼Ó ¤¤¤¤
		// 6 10 9 8 = 33
		
		// ÀüÀü²¬ ¾È¸¶¼ÌÀ» ¶§ÀÇ ÃÖ´ñ°ª. 
		
		dp[1] = map[1];
		if (n >= 2) {
			dp[2] = map[1]+map[2];
		}
		
		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i-3]+map[i-1], dp[i-2]) + map[i];
			System.out.println(i + " " + dp[i]);
		}
		System.out.println(Math.max(dp[n], dp[n-1]));
	}
}
