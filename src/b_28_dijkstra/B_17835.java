package b_28_dijkstra;
import java.io.*;
import java.util.*;

//다시 풀기 
public class B_17835 {
	static ArrayList<Integer> iv = new ArrayList<>();
	static int n;
	static ArrayList<int[]>[] adj;
	private static int[] solve(int st) {
		
		int[] d = new int[n+1];
		PriorityQueue<int[]> qu = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]- o2[1]; //거리 순 오름차순. 
			}
		});
		
		Arrays.fill(d, Integer.MAX_VALUE/1000);
		d[st] = 0;
		
		int[] tmp = {st, d[st]};
		qu.add(tmp);
		
		while (!qu.isEmpty()) {
			int[] q = qu.poll();
			if (d[q[0]] != q[1]) continue;
			
			for (int[] nxt : adj[q[0]]) {
				if (d[nxt[0]] < d[q[0]] + nxt[1]) continue;
				
				d[nxt[0]] = d[q[0]] + nxt[1];
				int[] tmp2 = {nxt[0], d[nxt[0]]};
				qu.add(tmp2);
			}
		}
		
		int min_index = -1;
		int min = Integer.MAX_VALUE;
		for (int kk : iv) {
			if (min > d[kk]) {
				min = d[kk];
				min_index = kk;
			}
		}
		int[] res = {min_index, min};
		return res;
		
	}
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());		
		
		adj = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<>();
		}
		
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int[] tmp = {v,c};
			adj[u].add(tmp);			
		}
		
		int[] res = new int[n+1]; //면접장을 담는 배열. 
		int[] d = new int[n+1]; //면접장과의 거리를 담는 배열. 
		Arrays.fill(d, -1);
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < k; i++) {
			int kk = Integer.parseInt(st.nextToken());
			iv.add(kk);
			
			res[kk] = kk;
			d[kk] = 0;
		}
		
		int max = 0;
		for (int i = 1; i <= n; i++) {
			
			if (d[i] == 0) continue;
			int[] value = solve(i);
			res[i] = value[0];
			d[i] = value[1];
			//System.out.println(i + ": " + res[i] + " " + d[i]);
			if (d[max] < d[i]) {
				max = i;
			}
		}
		
		System.out.println(max);
		System.out.println(d[max]);
		
		
		
	}
}











