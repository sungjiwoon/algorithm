package b_23_graph;

import java.io.*;
import java.util.*;
/*
 * 회장뽑기 (골드 5) 
 * 그래프 + bfs이용. 
 */
public class B_2660 {
	
	public void work() throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		HashMap<Integer, ArrayList<Integer>> hs = new HashMap<>();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a == -1) break;
			
			ArrayList<Integer> list = hs.get(a);
			if (list == null) 	list = new ArrayList<>();	
			list.add(b);
			hs.put(a, list);
			
			ArrayList<Integer> list2 = hs.get(b);
			if (list2 == null) list2 = new ArrayList<>();	
			list2.add(a);
			hs.put(b, list2);
			
		}
		
		int[][] arr = new int[n+1][n+1];
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) arr[i][j] = 100;
			arr[i][i] = 0;
		}
		
		for (int i = 1; i <= n; i++) {
			Queue<Integer> qu = new LinkedList<>();
			qu.add(i);
			boolean[] vis = new boolean[n+1];
			while (!qu.isEmpty()) {
				int p = qu.poll();
				ArrayList<Integer> list = hs.get(p);
				for (int l : list) {
					if (vis[l] || l == i) continue;
					arr[i][l] = arr[l][i] = Math.min(arr[i][p]+1, arr[i][l]);
					vis[l] = true;
					qu.add(l);
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		int[] res = new int[n+1];
		for (int i = 1; i <= n; i++) {
			int max = 0;
			for (int j = 1; j <= n; j++) {
				if (i == j ) continue;
				max = Math.max(arr[i][j], max);
			}
			res[i] = max;
		}
		
		int min = n+1;
		for (int i = 1; i <= n; i++) {
			min = Math.min(min, res[i]);
		}
		
		ArrayList<Integer> ts = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (res[i] == min) {
				ts.add(i);
			}
		}
		
		System.out.println(min + " " + ts.size());
		for (int l : ts) {
			System.out.print(l + " ");
		}
		
	}
}
