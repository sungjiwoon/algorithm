package b_28_dijkstra;
import java.io.*;
import java.util.*;

//다시 풀기 

/* 면접보는 승범이네 (골드 2) 
 * 다익스트라 
 * 면접장->집 까지 중 최소 거리를 구하는 것이 포인트이다. 
 * 모든 도시를 갈 수 있는것이 확정이므로. 
 * 다만 반대의 거리이므로 입력받을 때 거꾸로 해줘야함...
 */
public class B_17835 {	
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());		
		
		ArrayList<int[]>[] adj = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<>();
		}
		
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int[] tmp = {u,c}; //면접장에서 찾을 거니. 반대루트를 따라야함!! 
			adj[v].add(tmp);			
		}	
		
		
		//면접장에서 가장 가까운 도시를 찾아 return;; 
		PriorityQueue<long[]> qu = new PriorityQueue<>(new Comparator<long[]>() {
			@Override
			public int compare(long[] o1, long[] o2) {
				return (int)(o1[1] - o2[1]);
			}
		});
		
		long[] d = new long[n+1];
		Arrays.fill(d, 100_000_000_000L);
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < k; i++) {
			int kk = Integer.parseInt(st.nextToken());
			d[kk] = 0;
			long[] tmp = {kk, d[kk]};
			qu.add(tmp);
		}
		
		while (!qu.isEmpty()) {
			long[] q = qu.poll();
			
			if (d[(int)q[0]] != q[1]) continue;
			
			for (int[] nxt : adj[(int)q[0]]) {
				if (d[nxt[0]] < q[1] + nxt[1]) continue;
				d[nxt[0]] = q[1] + nxt[1];
				long[] tmp2 = {nxt[0], d[nxt[0]]};
				qu.add(tmp2);
			}
			
		}
		
		int max = 1;
		for (int i = 1; i <= n; i++) {
			//System.out.println(i + " : " +d[i] + " ");
			if (d[max] < d[i]) {
				max = i;
			}
		}
		
		System.out.println(max);
		System.out.println(d[max]);
		
		
	}
}











