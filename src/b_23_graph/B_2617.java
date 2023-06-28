package b_23_graph;

import java.io.*;
import java.util.*;

/*
 * 구슬 찾기
 * 구슬이 이긴 횟수나 진 횟수가 절반을 넘기면 중간이 아니게됨!!
 * 
 */
public class B_2617 {
	private static boolean solve(int i, ArrayList<Integer>[] al, int n) {
		int cnt = 0;
		boolean[] vis = new boolean[n+1];
		Queue<Integer> qu = new LinkedList<>();
		qu.add(i);
		vis[i] = true;
		while (!qu.isEmpty()) {
			int q = qu.poll();
			for (int nxt : al[q]) {
				if (vis[nxt]) continue;
				cnt++;
				qu.add(nxt);
				vis[nxt] = true;
			}
		}
		
		if (cnt > (n)/2) return false;
		return true;
		
	}
	public void work() throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		
		ArrayList<Integer>[] heavy = new ArrayList[n+1];
		ArrayList<Integer>[] light = new ArrayList[n+1];
		
		for (int i = 1; i <= n; i++) {
			heavy[i] = new ArrayList<>();
			light[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// a > b
			heavy[a].add(b);
			light[b].add(a);
		}
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			
			boolean ok = (solve(i, heavy, n) && solve(i, light, n));
			if (!ok) {
				System.out.println(i);
				cnt++;
			}
			
		}
		
		System.out.println(cnt);
		
		
	}
}








