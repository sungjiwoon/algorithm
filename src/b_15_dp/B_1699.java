package b_15_dp;

import java.io.*;
import java.util.Arrays;
/*
 * 제곱수의 합 성공
 
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	52612	21211	15416	39.378%
문제
어떤 자연수 N은 그보다 작거나 같은 제곱수들의 합으로 나타낼 수 있다. 
예를 들어 11=32+12+12(3개 항)이다. 이런 표현방법은 여러 가지가 될 수 있는데,
11의 경우 11=22+22+12+12+12(5개 항)도 가능하다. 이 경우, 수학자 숌크라테스는 “11은 3개 항의 제곱수 합으로 표현할 수 있다.”라고 말한다. 또한 11은 그보다 적은 항의 제곱수 합으로 표현할 수 없으므로, 11을 그 합으로써 표현할 수 있는 제곱수 항의 최소 개수는 3이다.

주어진 자연수 N을 이렇게 제곱수들의 합으로 표현할 때에 그 항의 최소개수를 구하는 프로그램을 작성하시오.
 */
public class B_1699 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[n+1];
		
		Arrays.fill(dp, 100000);
		dp[0] = 0;
		dp[1] = 1;
		int rt = 1;		
		
		for (int i = 2; i <= n; i++) {
			
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i-j*j]+1);
			}
		}
		//128 -> 64+64 가 최솟값임!!!!! 
		System.out.println(dp[n]);	
		
				
	}
}
