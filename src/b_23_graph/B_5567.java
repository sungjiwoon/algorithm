package b_23_graph;

import java.io.*;
import java.util.*;
/*
 * 
 * 문제 : 결혼식 (실버 2) 
 * 1초 
 * 상근이는 자신의 결혼식에 학교 동기 중 자신의 친구와 친구의 친구를 초대하기로 했다. 
 * 상근이의 동기는 모두 N명이고, 이 학생들의 학번은 모두 1부터 N까지이다. 상근이의 학번은 1이다.

상근이는 동기들의 친구 관계를 모두 조사한 리스트를 가지고 있다. 
이 리스트를 바탕으로 결혼식에 초대할 사람의 수를 구하는 프로그램을 작성하시오.

그래프 풀이 
 */
public class B_5567 {
	static int n, cnt = 0;
	static int[][] graph;
	static int[] arr;
	
	private static void dfs(int depth, int index) {
		if (depth > 2) return;
		
		for (int i = 2; i <= n; i++) {
			if (graph[index][i] == 1) {
				System.out.println(index + " " + i + ", depth :" + depth);
				arr[i] = Math.min(depth, arr[i]);
				
				dfs(depth+1, i);

			}
		}
		
	}
	public void work() throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		graph = new int[n+1][n+1];
		for (int i = 1; i <= m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = graph[b][a] = 1;
		}
		arr = new int[n+1];
		Arrays.fill(arr, 501);
		dfs(1, 1);
		
		for (int i = 2; i <= n; i++) {
			if (arr[i] < 3) cnt++;
		}
		System.out.println(cnt);
		
	}
}
