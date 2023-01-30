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
		
		//i번째 계단까지 올라섰을 때 밟지 않을 계단의 합의 최솟값, 
		//단 i번째 계단은 반드시 밟지 않을 계단.	그러면 i-1 계단은 무조건 밟아야함. 	
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = arr[1]; //1을 안밟음
		dp[2] = arr[2];  //2를 안밟음.
		dp[3] = arr[3]; //3 안 밟고, 1 2 밟는 느낌. 
		for (int i = 4; i <= n-1; i++) {
			dp[i] = Math.min(dp[i-2], dp[i-3]) + arr[i];
		}
		dp[n] -= Math.min(dp[n-2], dp[n-3]);
		System.out.println(dp[n]);
	}
}
