package b_15_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_12852 {
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		int[] pre = new int[n+1];
		dp[0] = 0;
		dp[1] = 0;
		for (int i = 2; i <= n; i++) { //i를 1로 만들기 위한 필요한 연산 사용 횟수의 최솟값. 
			dp[i] = dp[i-1]+1; 
			pre[i] = i-1;
			if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
				dp[i] = Math.min(dp[i], dp[i/2]+1);
				pre[i] = i/2;
			} 			
			if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
				dp[i] = Math.min(dp[i], dp[i/3]+1);
				pre[i] = i/3;
			} 
			
		}
		System.out.println(dp[n]);
		int cur = n;
		while (true) {
			System.out.print(cur + " ");
			if (cur == 1) break;
			
			cur = pre[cur];
			
		}
		
	}
}
