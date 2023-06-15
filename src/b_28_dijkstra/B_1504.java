package b_28_dijkstra;

import java.io.*;
import java.util.*;
/*
 * 
 * 아~~~~~~~~~
 * 양방향 다익스트라 문제 정말 어렵다~~~~~
 * 문제명 : 특정한 최단 경로 
 * 난이도 : 골드 4
 */
public class B_1504 {
	static final int INF = Integer.MAX_VALUE;
	static int n;
	static ArrayList<int[]>[] adj;
	
	private long solve(int st, int en) {
		
		PriorityQueue<int[]> qu = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		
		long[] d = new long[n+1];
		Arrays.fill(d, INF);
		d[st] = 0;
		
		int[] tmp = {st, 0};
		qu.add(tmp);
		
		while (!qu.isEmpty()) {
			int[] q = qu.poll();	
			
			for (int[] nxt : adj[q[0]]) {
				if (d[nxt[0]] <= d[q[0]] + nxt[1]) continue;
				d[nxt[0]] = d[q[0]] + nxt[1]; 
				int[] tmp2 = {nxt[0], (int) d[nxt[0]]};
				qu.add(tmp2);
			}
		}
		
		return d[en];
		
		
	}
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st= new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) adj[i] = new ArrayList<int[]>();
		
		while (e-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			int[] tmp = {b, c}; //끝 정점, 시간. 
			adj[a].add(tmp);
			
			int[] tmp2 = {a,c};
			
			adj[b].add(tmp2);
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		

//		for (int i = 1; i <= n; i++) {
//			for (int j = 1;j <= n; j++) {
//				System.out.print(solve(i,j) + "\t");
//			}
//			System.out.println();
//		} 
		
		
		
		long max = Math.min(solve(1,v1) + solve(v1,v2) + solve(v2,n), 
				solve(1,v2)+solve(v2,v1)+solve(v1,n));
		if (max >= INF) max = -1;
		System.out.println(max);
		
	}
}







