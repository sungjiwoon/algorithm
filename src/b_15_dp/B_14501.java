package b_15_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14501 {
	//어휴.. 이해 못했음 ㅠㅠ
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		/* 선언 및 초기화 부분 */
		int n = Integer.parseInt(br.readLine());
		int[] t = new int[17+n];
		int[] prices = new int[17+n];
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			t[i] = Integer.parseInt(st.nextToken()); 
			prices[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[17+n]; //i당 최대 가격  
		int max = 0;
		
		for (int i = 1; i <= n+1; i++) {
			
			dp[i] = Math.max(dp[i], max);
			dp[t[i] + i] = Math.max(dp[t[i]+i], prices[i]+dp[i]);
			max = Math.max(max,  dp[i]);
			
				
		}
		System.out.println(max);
		
		
	}
}
