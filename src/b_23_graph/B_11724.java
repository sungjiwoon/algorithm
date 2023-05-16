package b_23_graph;

import java.io.*;
import java.util.*;
/*
 * �׷����� ������ 
 * ���� ����� ���� ���� �ǹ�2
 
	�ð� ����	�޸� ����	����	����	���� ���	���� ����
	3 ��	512 MB	98873	44825	29578	42.301%
	����
	���� ���� �׷����� �־����� ��, ���� ��� (Connected Component)�� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
	�Է�
	ù° �ٿ� ������ ���� N�� ������ ���� M�� �־�����. (1 �� N �� 1,000, 0 �� M �� N��(N-1)/2) 
	��° �ٺ��� M���� �ٿ� ������ �� ���� u�� v�� �־�����. (1 �� u, v �� N, u �� v) ���� ������ �� ���� �־�����.
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
		//1. dfs ���� �׷��� 
		for (int i = 1; i <= n; i++) {
			if (!vis[i]) {
				sb.append("����� " + i+"\n");
				dfs(i);
				res++;
				sb.append("\n");
			}
		}
		System.out.println(sb);
		System.out.println(res);
		
		sb = new StringBuilder();
		int area = 0; //bfs�� ��. 
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
