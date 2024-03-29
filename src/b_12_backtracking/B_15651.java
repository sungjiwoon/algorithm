package b_12_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
/* 문제명 : N과 M 3
 * 난이도 : 실버 3
 * 중복 순열 같은 수 가능 
 * 입력
	첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 7)
	
	출력
	한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
	
	수열은 사전 순으로 증가하는 순서로 출력해야 한다.
	
	예제 입력 1 
	3 1
	예제 출력 1 
	1
	2
	3
	예제 입력 2 
	4 2
	예제 출력 2 
	1 1
	1 2
	1 3
	1 4
	2 1
	2 2
	2 3
	2 4
	3 1
	3 2
	3 3
	3 4
	4 1
	4 2
	4 3
	4 4
	예제 입력 3 
	3 3
	예제 출력 3 
	1 1 1
	1 1 2
	1 1 3
	1 2 1
	1 2 2
	1 2 3
	1 3 1
	1 3 2
	1 3 3
	2 1 1
	2 1 2
	2 1 3
	2 2 1
	2 2 2
	2 2 3
	2 3 1
	2 3 2
	2 3 3
	3 1 1
	3 1 2
	3 1 3
	3 2 1
	3 2 2
	3 2 3
	3 3 1
	3 3 2
	3 3 3

 */
public class B_15651 {
	static int n, m;
	static int[] arr;
	static boolean[] isused;
	static StringBuilder sb;
	private static void func(int idx) {
		if (idx == m) {
			for (int i = 0; i < m; i++) {
				sb.append(arr[i]+ " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= n; i++) {
				arr[idx] = i;
				func(idx+1);
		}
	}
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb= new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m+1];
		isused = new boolean[n+1];
		func(0);
		System.out.print(sb);
	}
}
