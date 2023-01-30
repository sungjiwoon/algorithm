package b_15_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 문제 명 : 구간 합 구하기 4
 * 난이도 : 실버 3
 * 문제
	수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.
	
	입력
	첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다. 둘째 줄에는 N개의 수가 주어진다. 수는 1,000보다 작거나 같은 자연수이다. 셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.
	
	출력
	총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.
	
	제한
	1 ≤ N ≤ 100,000
	1 ≤ M ≤ 100,000
	1 ≤ i ≤ j ≤ N
	예제 입력 1 
	5 3
	5 4 3 2 1
	1 3
	2 4
	5 5
	예제 출력 1 
	12
	9
	1
 */
public class B_11659 {
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[1000002];
		int[] dp = new int[1000002];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = arr[1];
		for (int i = 1; i <= n; i++) {
			dp[i] = dp[i-1] + arr[i];
		}
		//dp[i] = 1~i까지의 합 
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int res = dp[b]-dp[a-1];
			System.out.println(res);
		}

	}
}
