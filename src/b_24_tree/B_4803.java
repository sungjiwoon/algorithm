package b_24_tree;

import java.io.*;
import java.util.*;

/*
 * 트리 골드 4 1초, 256MB
 * 그래프는 정점과 간선으로 이루어져 있다. 두 정점 사이에 경로가 있다면, 두 정점은 연결되어 있다고 한다. 
 * 연결 요소는 모든 정점이 서로 연결되어 있는 정점의 부분집합이다. 그래프는 하나 또는 그 이상의 연결 요소로 이루어져 있다.

	트리는 사이클이 없는 연결 요소이다. 트리에는 여러 성질이 있다. 예를 들어, 트리는 정점이 n개, 간선이 n-1개 있다. 
	또, 임의의 두 정점에 대해서 경로가 유일하다.
	
	그래프가 주어졌을 때, 트리의 개수를 세는 프로그램을 작성하시오.
 */
public class B_4803 {
	static int cnt = 0;
	private static void is_tree(int n, HashMap<Integer, ArrayList<Integer>> hs) {
		
		/*
		 * 트리의 조건 : 
		 * 사이클 X 정점 n개 간선 n-1개?? 
		 */
		
		boolean[] vis = new boolean[n+1];
		for (int i = 1; i <= n; i++) {
			if (!vis[i]) {
				ArrayList<Integer> list = hs.get(i);
				if (list.isEmpty()) {
					cnt++;
					vis[i] = true;
				} else {
					if (dfs(0,i, vis, hs)) cnt++;
				}
			}
		}
		
	}
	private static boolean dfs(int before, int key, boolean[] vis, HashMap<Integer, ArrayList<Integer>> hs) {
		
		ArrayList<Integer> list = hs.get(key);
		if (vis[key]) return false;
		vis[key] = true;
		for(int l : list) {
			if (before == l) continue;
			//System.out.println("key: " + key + ", l:" + l);
			boolean ok = dfs(key, l, vis, hs);
			if (!ok) return false;
			
		}
		return true;
		
	}
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int tc = 1;
		while (n != 0 && m != 0) {
		
			HashMap<Integer, ArrayList<Integer>> hs = new HashMap<>();
			for (int i = 1; i <= n; i++) {
				ArrayList<Integer> list = new ArrayList<>();
				hs.put(i, list);
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				ArrayList<Integer> list = hs.get(a);
				list.add(b);
				hs.put(a, list);
				
				list = hs.get(b);
				list.add(a);
				hs.put(b, list);
			}
			
			cnt = 0; //트리의 갯수 . 
			is_tree(n, hs);
			if (cnt == 1) sb.append("Case " + tc + ": There is one tree.\n");
			else if (cnt == 0) sb.append("Case " + tc + ": No trees.\n");
			else {
				sb.append("Case " + tc + ": A forest of " + cnt + " trees.\n");
			}
			tc++;
			
			//초기화.
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
		}
		System.out.println(sb);
		
	}
}
