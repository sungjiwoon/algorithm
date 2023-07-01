package b_09_bfs;

import java.io.*;
import java.util.*;
/*
 * ¼û¹Ù²ÀÁú 3
 * BFS 
 * °ñµå5
 * 
 */
public class B_13549 {
	static final int INF = 100001;
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] dx = {-1,1};
		
		int[] dis = new int[INF];
		Arrays.fill(dis, -1);
		int ans = INF;
		
		Queue<Integer> qu = new LinkedList<>();
		dis[n] = 0;
		qu.add(n);
		
		while (!qu.isEmpty()) {
			int q = qu.poll();
			
			if (q == k) break;
			
			if (q*2 < INF && dis[q*2] == -1) {
				qu.add(q*2);
				dis[q*2] = dis[q];
			}
			
			for (int kk = 0; kk < 2; kk++) {
				int xx = q+dx[kk];
				if (xx < 0 || xx >= INF || dis[xx] != -1) continue;
				dis[xx] = dis[q]+1;
				qu.add(xx);
			}
		}
		
		
		System.out.println(dis[k]);
		
	}
}
