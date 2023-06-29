package b_25_topology_sort;

import java.io.*;
import java.util.*;
/*
 * 문제집 (골드2)
 * 그래프 순서 정하기 : 위상정렬
 * 난이도 순으로 출력하기 : 우선힙.
 */
public class B_1766 {
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] list = new int[n+1];
		
		ArrayList<Integer>[] adj = new ArrayList[n+1];
		for (int i = 1; i<= n; i++) adj[i] = new ArrayList<>();
		
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adj[a].add(b);
			list[b]++;
		}
		
		PriorityQueue<Integer> qu = new PriorityQueue<>();
		for (int i = 1; i <= n; i++) {
			if (list[i]== 0) qu.add(i);
		}
		
		int[] res = new int[n+1];
		int j = 1; // 순서. 
		
		while (!qu.isEmpty()) {
			int q = qu.poll();
			res[j++] = q;
			
			for (int w : adj[q]) {
				list[w]--;
				if (list[w] == 0) qu.add(w);
			}
			
		}
		
		for (int i = 1; i <= n; i++) {
			System.out.print(res[i]+ " ");
		}
		
	}
}






