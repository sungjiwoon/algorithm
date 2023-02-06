package b_15_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 가장 긴 증가하는 부분 수열 성공
 
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	256 MB	126785	50009	32989	37.397%
문제
수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.

예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.

입력
첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.

둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)

출력
첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.

예제 입력 1 
6
10 20 10 30 20 50
예제 출력 1 
4
 */
public class B_11053 {
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
		
		dp[1] = 1; //dp[i] = i번째 인덱스에서 가장 긴 수열의 갯수. 
		for (int i = 2; i <= n; i++) {
			
			int v = values[i];
			dp[i] = 1; //일단 i값은 처음에는 초기화.
			for (int j = 1; j < i; j++) {
				if (v > values[j]) {
					dp[i] = Math.max(dp[j]+1, dp[i]);
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
