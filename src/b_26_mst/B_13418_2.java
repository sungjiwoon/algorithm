package b_26_mst;

import java.io.*;
import java.util.*;

/*
 * 학교 탐방하기 (골3)
 * 크루스칼 알고리즘 
 */
public class B_13418_2 {
	static int n;
	static int[] parent;
	
	private static int find(int x) {
		if (parent[x] == x ) return x;
		return parent[x] = find(parent[x]);
	}
	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		parent[y] = x;
	}
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(st.nextToken());
		int[][] graph1 = new int[m+1][3]; // 0: 정점 1, 1 : 정점 2, 2 : v
		int[][] graph2 = new int[m+1][3];
		
		for (int i = 0; i <= m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph1[i][0] = x;
			graph1[i][1] = y;
			graph1[i][2] = v;
			graph2[i][0] = x;
			graph2[i][1] = y;
			graph2[i][2] = v;
		}
		
		parent = new int[n+1];
		for (int i = 0; i <= n; i++) parent[i] = i;
		
		//최소 오르막길 구하기. 1-> 내리막길. 
		Arrays.sort(graph1, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o2[2]-o1[2];
			}
		});
		
		int k1 = 0;
		for (int i = 0; i <= m; i++) {
			if (find(graph1[i][0]) != find(graph1[i][1])) {
				union(graph1[i][0], graph1[i][1]);
				if (graph1[i][2] == 0) k1++;
			}
		}
		k1 = (int)(Math.pow(k1, 2));
		
		for (int i = 0; i <= n; i++) parent[i] = i;
		Arrays.sort(graph2, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2]-o2[2];
			}
		});
		
		int k2 = 0;
		for (int i = 0; i <= m; i++) {
			if (find(graph2[i][0]) != find(graph2[i][1])) {
				union(graph2[i][0], graph2[i][1]);
				if (graph2[i][2] == 0) k2++;
			}
		}
		k2 = (int)(Math.pow(k2, 2));
		System.out.println(k2-k1);
	}
}
