package b_15_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 문제 명 : 연속 합 
 * 난이도 : 실버 2
 * 문제
	n개의 정수로 이루어진 임의의 수열이 주어진다. 우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 
	가장 큰 합을 구하려고 한다. 단, 수는 한 개 이상 선택해야 한다.
	
	예를 들어서 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어졌다고 하자. 
	여기서 정답은 12+21인 33이 정답이 된다.
	
	입력
	첫째 줄에 정수 n(1 ≤ n ≤ 100,000)이 주어지고 둘째 줄에는 n개의 정수로 이루어진 수열이 주어진다. 
	수는 -1,000보다 크거나 같고, 1,000보다 작거나 같은 정수이다.
	
	출력
	첫째 줄에 답을 출력한다.
	
	예제 입력 1 
	10
	10 -4 3 1 5 6 -35 12 21 -1
	예제 출력 1 
	33
 */
public class B_1912 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		/* 선언 및 초기화 부분 */
		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[100001];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		long[] dp = new long[n+1];
		long mx = arr[1];
		for (int i = 1; i <= n; i++) {
			dp[i] = Math.max(dp[i-1] + arr[i], arr[i]); //i번째에서 합 중 큰 값. 
			mx = Math.max(dp[i], mx); //지금까지의 최댓값 비교. 
		}
		System.out.println(mx);
	}
}
