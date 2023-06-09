package b_26_mst;

import java.io.*;
import java.util.*;

public class B_1368 {

	public void work() throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		//굳이 다른 논과 연결할 필요 없고, 논에 물이 있으면 됨!!!
		
		int[] cost = new int[n+1];
		int min_index = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			cost[i] = Integer.parseInt(br.readLine());
			if (min > cost[i]) {
				min = cost[i];
				min_index = i;
			}
		}
		
		
		HashMap<Integer, ArrayList<int[]>> hm = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			hm.put(i, new ArrayList<int[]>());
		}
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			ArrayList<int[]> list = hm.get(i);
			for (int k = 1; k<=n; k++) {
				int v = Integer.parseInt(st.nextToken());
				int[] tmp = {k,v};
				list.add(tmp);
			}
			hm.put(i, list);
		}
		
		//우선순위 큐 : 최솟값 정렬하는. 
		PriorityQueue<int[]> qu = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1]-o2[1];
			}
		});
		
		
		ArrayList<int[]> list = hm.get(min_index);
		for (int[] l : list) {
			qu.add(l);
		}
		
		int cnt = 1;
		int ans = cost[min_index];
		boolean[] vis = new boolean[n+1];
		vis[min_index] = true;
		
		while (cnt < n) {
			int[] q = qu.poll();
			while (vis[q[0]]) q = qu.poll();
			
			if (q[1] < cost[q[0]]) {
				ans += q[1];
			}
			vis[q[0]] = true;
			cnt++;
			list = hm.get(q[0]);
			for (int[] l : list) {
				if (vis[l[0]]) continue;
				qu.add(l);
			}
			
		}
		System.out.println(ans);
		
	}
}









