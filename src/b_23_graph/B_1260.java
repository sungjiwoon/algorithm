package b_23_graph;

import java.io.*;
import java.util.*;
/*
 * DFS와 BFS 성공
 
	시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
	2 초	128 MB	233258	88378	52439	36.717%
	문제
	그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 
	단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 
	더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
 */
public class B_1260 {
	
	static int n,m,v;
	static int[][] arr = new int[1001][1001];
	static boolean[] vis = new boolean[1001];
	
	private static void dfs(int index, StringBuilder sb) {
		if (vis[index]) return;
		
		sb.append(index+" ");
		vis[index] = true;
		for (int i = 1; i <= n; i++) {
			if (!vis[i] && arr[index][i] == 1) {
				dfs(i, sb);
			}
		}
	}
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = arr[b][a] = 1;
		}
		
		//dfs 수행 먼저 
		StringBuilder sb = new StringBuilder();
		dfs(v, sb);
//		for (int i = 1; i <= n; i++) {
//			if (!vis[i]) dfs(i, sb);
//		}
		sb.append("\n");
		
		//bfs 구간 
		Queue<Integer> qu = new LinkedList<>();
		vis = new boolean[1001];
		qu.add(v);
		vis[v] = true;
		while (!qu.isEmpty()) {
			int q = qu.poll();
			sb.append(q+" ");					
			for (int j = 1; j <= n; j++) {
				if (arr[q][j] == 1 && !vis[j]) {
					vis[j] = true;
					qu.add(j);
				}
			}
		}
		System.out.println(sb);
		
		
		
	}
}
