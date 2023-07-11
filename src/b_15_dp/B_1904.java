package b_15_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1904 {
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[n+1];
		
		dp[1] = 1; //1
		if (n >= 2) dp[2] = 2; //00, 11
		
//		dp[3] = 3; //001, 100, 111
//		dp[4] = 5;//0000, 1001, 0011, 1100, 1111
//		
//		dp[5] = 8;//00111, 11100, 10011, 11001, 00001, 10000, 00100, 11111
		//짝수일 땐, 0으로 이루어진 수가 하나 추가되고,
		//전체 수에선 +1, 
		
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
			dp[i] %= 15746;
		}
		System.out.println(dp[n]);
	}
}
