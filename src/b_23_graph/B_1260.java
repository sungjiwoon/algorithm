package b_23_graph;

import java.io.*;
import java.util.*;
/*
 * DFS�� BFS ����
 
	�ð� ����	�޸� ����	����	����	���� ���	���� ����
	2 ��	128 MB	233258	88378	52439	36.717%
	����
	�׷����� DFS�� Ž���� ����� BFS�� Ž���� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. 
	��, �湮�� �� �ִ� ������ ���� ���� ��쿡�� ���� ��ȣ�� ���� ���� ���� �湮�ϰ�, 
	�� �̻� �湮�� �� �ִ� ���� ���� ��� �����Ѵ�. ���� ��ȣ�� 1������ N�������̴�.
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
		
		//dfs ���� ���� 
		StringBuilder sb = new StringBuilder();
		dfs(v, sb);
//		for (int i = 1; i <= n; i++) {
//			if (!vis[i]) dfs(i, sb);
//		}
		sb.append("\n");
		
		//bfs ���� 
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
