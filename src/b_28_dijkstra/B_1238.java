package b_28_dijkstra;
import java.io.*;
import java.util.*;

/*
 * 파티 (꼴3) 다익스트라 
 * 모든 정점을 기준으로 다익스트라 정렬.
 */
public class B_1238 {
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		ArrayList<int[]>[] adj = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<int[]>();
		}
		
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int[] tmp = {j,t}; //끝 정점, 시간. 
			adj[i].add(tmp);
		}
		
		//시간 기준으로 우선순위 큐 정렬. 
		PriorityQueue<int[]> qu = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[]o2) {
				// TODO Auto-generated method stub
				return o1[1] - o2[1];
			}
		});
		
		// X가 시작 정점. 
		int[][] d = new int[n+1][n+1];// x 정점을 기준으로  x -> 우리 집까지의 거리들 합. 
		//Arrays.fill(d, Integer.MAX_VALUE);
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) 
				d[i][j] = Integer.MAX_VALUE;
			d[i][i] = 0;
		}
		
		for (int i = 1; i <= n; i++) {
			int[] tmp = {i, d[i][i]};
			qu.add(tmp);
			
			// 우리집 -> x까지의 거리의 최소. 
			while (!qu.isEmpty()) {
				int[] q = qu.poll();
				for (int[] nxt : adj[q[0]]) {
					if (d[i][nxt[0]] <= d[i][q[0]] + nxt[1]) continue;
					d[i][nxt[0]] = d[i][q[0]] + nxt[1];
					int[] tmp2 = {nxt[0], d[i][nxt[0]]};
					qu.add(tmp2);
				}
			}
		}
		
		
		
		int max = 0;
		for (int i = 1; i <= n; i++) {
			if (i == x) continue;
			max = Math.max(max, d[i][x] + d[x][i]);
			System.out.println(i + " " + d[i][x] + " " + d[x][i]);
		}
		System.out.println(max);
		
		
	}
}










