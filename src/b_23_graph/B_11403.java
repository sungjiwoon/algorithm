package b_23_graph;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
/*
 * 경로 찾기 (실버1)
 * 
 * 가중치 없는 방향 그래프 G가 주어졌을 때, 모든 정점 (i, j)에 대해서, 
 * i에서 j로 가는 경로가 있는지 없는지 구하는 프로그램을 작성하시오.
 * 
 * 그래프 이용하여 BFS로 풀었다. 
 * 
 */
public class B_11403 {
	
	public void work() throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//초기화 선언. 
		int n = Integer.parseInt(br.readLine());
		
		TreeMap<Integer, ArrayList<Integer>> tm = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				if (st.nextToken().equals("1")) {
					if (tm.get(i) != null) {
						ArrayList<Integer> list = tm.get(i);
						list.add(j);
						tm.put(i, list);
					} else {
						ArrayList<Integer> list = new ArrayList<>();
						list.add(j);
						tm.put(i, list);
					}					
				}
			}
		}
		
		int[][] graph = new int[n][n];	
		for (int p = 0; p < n; p++) {
			ArrayList<Integer> list = tm.get(p);
			if (list == null) continue;
			
			Queue<Integer> qu = new LinkedList<>();
			boolean[] vis = new boolean[n];
			boolean ok = true;
			while (ok) {				
				for (int l : list) {
					graph[p][l] = 1;
					/* 방문하지 않는 정점만 queue에 추가한다. */
					if (!vis[l])
						qu.add(l);
					vis[l] = true;
					//System.out.println(p + " : " + l);
				}
				
				if (qu.isEmpty()) break;
				
				/* list가 null이면 queue에서 다른 정점을 찾아 꺼내준다. */				
				list = tm.get(qu.poll());
				while (list == null) {
					if (qu.isEmpty()) {
						ok = false;
						break;
					}
					list = tm.get(qu.poll());
				}
			}
		}
		
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(graph[i][j] + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
		
		
	}
}
