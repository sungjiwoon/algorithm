package b_15_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 문제 명 : 2x1 타일링 
 * 난이도 : 실버 3
 * 문제
	2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
	
	입력
	첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)
	
	출력
	첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
	
	예제 입력 1 
	2
	예제 출력 1 
	2
	예제 입력 2 
	9
	예제 출력 2 
	55
 */
public class B_11726 {
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[n+1];
		
		//i번째 계단까지 올라섰을 때 밟지 않을 계단의 합의 최솟값, 
		//단 i번째 계단은 반드시 밟지 않을 계단.	그러면 i-1 계단은 무조건 밟아야함. 	
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		
		for (int i = 4; i <= n; i++) {
			dp[i] = dp[i-1]+dp[i-2];
			dp[i] %= 10007;
		}
		System.out.println(dp[n]);

	}
}
