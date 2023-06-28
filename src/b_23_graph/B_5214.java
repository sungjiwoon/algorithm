package b_23_graph;
import java.io.*;
import java.util.*;
/*
 * 환승 
 * 모든 정점에 간선을 연결하는 것은 불가능하다. 그러니 중앙역 혹은 집합으로 만들어서 그래프로 표현하였다. 
 */
public class B_5214 {
	static final int INF = 100000+1;
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] adj = new ArrayList[n+1];
		for (int i = 1; i<= n; i++) adj[i] = new ArrayList<>();
			
		//지하철 보관 용.
		ArrayList<Integer>[] subway = new ArrayList[m+1];
		
		Queue<Integer> qu = new LinkedList<>();
		
		HashMap<Integer, Integer> end = new HashMap<>(); //종착역을 담는 역들 집합.
		int[] route = new int[m+1];
		Arrays.fill(route, INF);
		
		for (int j = 1; j <= m; j++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			subway[j] = new ArrayList<>();
			for (int i = 0; i < k; i++) {
				int v = Integer.parseInt(st.nextToken());
				subway[j].add(v);
				adj[v].add(j);
				
				if (v == 1) {
					qu.add(j);
					route[j] = 1;
				}
				if (v == n) end.put(j, 1);
			}
		}

		boolean[] vis_st = new boolean[n+1]; //역들의 방문. 
		vis_st[1] = true;
		boolean[] vis_sub = new boolean[m+1]; //역들의 집합이 담긴 곳의 방문 표기
		int ans = INF;
		
		while (!qu.isEmpty()) {
			int num = qu.poll(); //역들의 번호가 담겼음. 
			vis_sub[num] = true;
			System.out.println(num);
			
			if (end.containsKey(num)) {
				ans = Math.min(route[num]+1, ans);
				break;
			}
			
			for (int nxt : subway[num]) {
				if (vis_st[nxt]) continue;
				vis_st[nxt] =true;
				
				for (int diff : adj[nxt]) {
					if (vis_sub[diff]) continue;
					route[diff] = Math.min(route[diff], route[num]+1);
					System.out.println(nxt + "역: ("+diff + ") " + route[diff]);
					qu.add(diff);
					vis_sub[diff] = true;
				}
			}
			
		}
		if (ans == INF) ans = -1;
		if (n == 1) ans = 1;
		System.out.println(ans);
		
		
	}
}











