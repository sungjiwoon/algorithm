package b_23_graph;

import java.io.*;
import java.util.*;
/*
 * 그래프의 기초인 
 * 연결 요소의 개수 성공 실버2
 
	시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
	3 초	512 MB	98873	44825	29578	42.301%
	문제
	방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
	
	입력
	첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 
	둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.
 */
public class B_11724 {
	static int[][] arr;
	static boolean[] vis;
	static int n, m, res = 0;
	static StringBuilder sb = new StringBuilder();
	private void dfs(int index) {
		
		if (vis[index]) return;
		
		vis[index] = true;
		for (int i = 1; i <= n; i++) {
			if (arr[index][i] == 1) {				
				dfs(i);
				sb.append(i+" ");
			}
		}
		
	}
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		
		arr = new int[n+1][n+1];
		for (int i = 0; i < m; i++) {
			 st = new StringTokenizer(br.readLine(), " ");
			 int a = Integer.parseInt(st.nextToken());
			 int b = Integer.parseInt(st.nextToken());
			 arr[a][b] = arr[b][a] = 1;
		}
		
		vis = new boolean[n+1];
		//1. dfs 버전 그래프 
		for (int i = 1; i <= n; i++) {
			if (!vis[i]) {
				sb.append("출발지 " + i+"\n");
				dfs(i);
				res++;
				sb.append("\n");
			}
		}
		System.out.println(sb);
		System.out.println(res);
		
		sb = new StringBuilder();
		int area = 0; //bfs용 답. 
		boolean[] vis2 = new boolean[n+1];
		Queue<Integer> qu = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			if (!vis2[i]) {				
				qu.add(i);
				area++;
				vis2[i] = true;
				sb.append(i + " ");
				while (!qu.isEmpty()) {
					int q = qu.poll();
					
					for (int j = 1; j <= n; j++) {
						if (arr[q][j] == 1 && !vis2[j]) {
							qu.add(j);
							vis2[j] = true;
							sb.append(j + " ");
						}
					}
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
		System.out.println(area);
		
		
		
	}
}
