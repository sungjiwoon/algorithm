import java.io.*;
import java.util.*;
import java.util.Map.Entry;


public class Main {	
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
	public static void main(String[] args) throws Exception {		
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
			else if (cnt == 0) sb.append("Case " + tc + ": No trees\n");
			else {
				sb.append("Case " + tc + ": A forest of " + cnt + " trees\n");
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
