package b_15_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 가장 큰 증가 부분 수열 (실버 2)
	문제
	수열 A가 주어졌을 때, 그 수열의 증가 부분 수열 중에서 합이 가장 큰 것을 구하는 프로그램을 작성하시오.
	
	예를 들어, 수열 A = {1, 100, 2, 50, 60, 3, 5, 6, 7, 8} 인 경우에 합이 가장 큰 증가 부분 수열은 A = {1, 100, 2, 50, 60, 3, 5, 6, 7, 8} 이고, 합은 113이다.
	
	입력
	첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.
	
	둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)
	
	출력
	첫째 줄에 수열 A의 합이 가장 큰 증가 부분 수열의 합을 출력한다.
	
	예제 입력 1 
	10
	1 100 2 50 60 3 5 6 7 8
	예제 출력 1 
	113
 */
public class B_11055 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		/* 선언 및 초기화 부분 */
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		int[] values = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			values[i] = Integer.parseInt(st.nextToken()); 
		}
		dp[1] = values[1];
		for (int i = 2; i <= n; i++) {
			
			dp[i] = values[i];
			for (int j = 1; j < i; j++) {
				if (values[i] > values[j]) {
					dp[i] = Math.max(dp[j]+values[i], dp[i]);
				}
			}
				
		}
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			if (dp[i] > max) max = dp[i];
		}
		System.out.println(max);
		
		
	}
}
