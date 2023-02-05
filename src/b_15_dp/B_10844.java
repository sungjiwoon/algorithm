package b_15_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 문제 명 : 쉬운 계단 수 
 * 난이도 : 실버 1
 * 문제
	45656이란 수를 보자.
	이 수는 인접한 모든 자리의 차이가 1이다. 이런 수를 계단 수라고 한다.
	
	N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구해보자. 0으로 시작하는 수는 계단수가 아니다.
	
	입력
	첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 100보다 작거나 같은 자연수이다.
	
	출력
	첫째 줄에 정답을 1,000,000,000으로 나눈 나머지를 출력한다.
	
	예제 입력 1 
	1
	예제 출력 1 
	9
	예제 입력 2 
	2
	예제 출력 2 
	17
 */
public class B_10844 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		/* 선언 및 초기화 부분 */
		int n = Integer.parseInt(br.readLine());
		
		long[][] dp = new long[101][10];
		for (int i = 1; i <= 9; i++) {
			dp[1][i] = 1;
		}
		
		for (int i = 2; i <= n; i++) {
			
			for (int j = 0; j <= 9; j++) {
				if (j == 0) {
					dp[i][j] = dp[i-1][j+1] % 1000000000;
				} else if (j == 9) {
					dp[i][j] = dp[i-1][j-1] % 1000000000;
				} else {
					dp[i][j] = dp[i-1][j-1] % 1000000000 +dp[i-1][j+1] % 1000000000;
				}
			}
		}
		long sum = 0;
		for (int i = 0; i <= 9; i++) {
			sum += dp[n][i];
		}
		
		System.out.println(sum % 1000000000);
		
		
	}
}
