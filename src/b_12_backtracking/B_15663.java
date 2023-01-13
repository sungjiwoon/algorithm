package b_12_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
/*
 * 문제 명 N과 M 9
 * 난이도 실버 2
 * 특징 : Hashset 함수 이용 . 중복을 걸러낸다는 큰 장점이 있다. StringBuilder 와 hashset 의 조합이 좋음!
 * 문제
	N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
	
	N개의 자연수 중에서 M개를 고른 수열
	입력
	첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
	
	둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.
	
	출력
	한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
	
	수열은 사전 순으로 증가하는 순서로 출력해야 한다.
	
	예제 입력 1 
	3 1
	4 4 2
	예제 출력 1 
	2
	4
	예제 입력 2 
	4 2
	9 7 9 1
	예제 출력 2 
	1 7
	1 9
	7 1
	7 9
	9 1
	9 7
	9 9
 */
public class B_15663 {
	static int M, N;
	static int[] nums, arr, before;
	static boolean[] vis;
	static StringBuilder sb;
	static HashSet<String> hs;
	private static void func(int idx, int st) {
		if (idx == M) {
			StringBuilder temp = new StringBuilder();
			
			for (int i = 0; i < M; i++) temp.append(arr[i] + " ");
				
			if (!hs.contains(temp.toString())) {
				sb.append(temp).append("\n");
				hs.add(temp.toString());
			}
			
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (!vis[i]) {
				vis[i] = true;
				arr[idx] = nums[i];
				func(idx+1, i);
				vis[i] = false;
			}
			
		}
					
	}
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(nums);
		arr = new int[M+1];
		hs = new HashSet<>();
		
		vis = new boolean[N+1];
		func(0,0);
		System.out.print(sb);
	}
}
