package b_09_bfs;


import java.io.*;
import java.util.*;

/*
 * 숨바꼭질 골4
 * 프리 배열을 두어 경로를 위치추적한다. 
 */
public class B_13913 {
	static final int INF = 100001;
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] dis = new int[INF];
		int[] pre = new int[INF];
		Arrays.fill(dis, -1);
		dis[n] = 0;
		pre[n] = n;
		
		Queue<Integer> qu = new LinkedList<>();
		qu.add(n);
		
		int[] dx = {-1,1,2};
		while (!qu.isEmpty()) {
			int q = qu.poll();
			if (q == k) break;
			for (int kk = 0; kk < 3; kk++) {
				int xx = q + dx[kk];
				if (kk == 2) xx = q * dx[kk];
				if (xx <0 || xx >= INF || dis[xx] != -1) continue;
				dis[xx] = dis[q]+1;
				pre[xx] = q;
				qu.add(xx);
			}
			
		}
		System.out.println(dis[k]);
		int x = k;
		while (x != n) {
			sb.insert(0,x+ " ");
			x = pre[x];
		}
		sb.insert(0, x + " ");
		System.out.println(sb);
	}
}
