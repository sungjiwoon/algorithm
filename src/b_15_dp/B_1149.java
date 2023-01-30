package b_15_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 문제 명 : RGB 거리 
 * 난이도 : 실버 1
 * 구성 : Dp이용.. dp는 참 어렵다. 
 * 문제
	RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.
	
	집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.
	
	1번 집의 색은 2번 집의 색과 같지 않아야 한다.
	N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
	i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
	입력
	첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다. 집을 칠하는 비용은 1,000보다 작거나 같은 자연수이다.
	
	출력
	첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.
	
	예제 입력 1 
	3
	26 40 83
	49 60 57
	13 89 99
	예제 출력 1 
	96
 */
public class B_1149 {
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] R = new int[n+1];
		int[] G = new int[n+1];
		int[] B = new int[n+1];
		
		StringTokenizer st;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			R[i] = Integer.parseInt(st.nextToken());
			G[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[n+1][3];
		
		/*
		 * dp[i][0] = i번째 까지 칠하는데, 최솟값 단 i는 레드
		 * dp[i][1] = i번째 까지 칠하는데, 최솟값 단 i는 그린
		 * dp[i][2] = i번째 까지 칠하는데, 최솟값 단 i는 블루
		 */
		
		//i번째 계단까지 올라섰을 때 밟지 않을 계단의 합의 최솟값, 
		//단 i번째 계단은 반드시 밟지 않을 계단.	그러면 i-1 계단은 무조건 밟아야함. 	
		dp[1][0] = R[1]; //R만 칠함
		dp[1][1] = G[1];  //G만 칠함
		dp[1][2] = B[1]; //B만 칠함
		
		for (int i = 2; i <= n; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + R[i];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + G[i];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + B[i];
		}
		
		int best = dp[n][0];
		for (int i = 0; i < 3; i++) {
			if (best > dp[n][i]) best = dp[n][i];
		}

		System.out.println(best);
	}
}
