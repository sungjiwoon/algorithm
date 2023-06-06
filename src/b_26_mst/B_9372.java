package b_26_mst;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

/*
 * 프림 알고리즘 이용
 * 상근이의 여행 (실4)
 */
public class B_9372 {

	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); 
		
		for (int t = 1; t <= T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
			for (int i = 1; i <= n; i++) hm.put(i, new ArrayList<Integer>());
			
			while (m-- > 0) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				ArrayList<Integer> list = hm.get(x);
				list.add(y);
				hm.put(x, list);
				
				list = hm.get(y);
				list.add(x);
				hm.put(y, list);
				
			}
			
			int cnt = 0; // 타야하는 비행기의 수 .
			boolean[] vis = new boolean[n+1];
			vis[1] = true;
			Queue<Integer> qu = new LinkedList<>(); //방문 정점 담는 곳. 
			qu.add(1);
			
			while (cnt < n-1) {
				int q = qu.poll();
				ArrayList<Integer> list = hm.get(q);
				for (int l : list) {
					if (vis[l]) continue;
					
					qu.add(l);
					vis[l] = true;
					cnt++;
				}
			}
			
			System.out.println(cnt);
			
		}
		
		
	}
}




