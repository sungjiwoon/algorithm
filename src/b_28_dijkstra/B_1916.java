package b_28_dijkstra;


import java.io.*;
import java.util.*;


public class B_1916 {
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		ArrayList<int[]>[] adj = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<int[]>();
		}
		
		while (m-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			int[] tmp = {b,c}; // 정점 , 비용  
			adj[a].add(tmp);
		}
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int[] d = new int[n+1]; // a -> i 지점으로 가는 최소 거리 집합. 
		Arrays.fill(d, Integer.MAX_VALUE);
		d[a] = 0;
		
		PriorityQueue<int[]> qu = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1]; //오름차순 정렬 .
			}
		});
		
		int[] at = {a, 0};
		qu.add(at);
		while (!qu.isEmpty()) {
			int[] q = qu.poll();
			if (d[q[0]] != q[1]) continue;
			
			for (int[] nxt : adj[q[0]]) {
				if (d[nxt[0]] < d[q[0]] + nxt[1]) continue;
				d[nxt[0]] = d[q[0]] + nxt[1];
				int[] tmp = {nxt[0], d[nxt[0]]};
				qu.add(tmp);
			}
		}
		
		
		System.out.println(d[b]);
		
	}
}









