package b_15_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_9095 {
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] dp = new int[n+1];
			dp[0] = 0;
			dp[1] = 1; //1
			dp[2] = 2; //1+1 2
			dp[3] = 4; //1+1+1, 1+2 2+1 3
			
			for (int i = 4; i <= n; i++) { //i를 1로 만들기 위한 필요한 연산 사용 횟수의 최솟값. 
				dp[i] = dp[i-1]+dp[i-2]+dp[i-3]; 			
				
			}
			System.out.println(dp[n]);
		}
	}
}
