package b_26_mst;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

/*
 * 행성 연걸 (골드4) 
 * 최소 신장 트리 
 * 프림 알고리즘으로 풀었다!! 
 */

public class B_16398 {
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		HashMap<Integer, ArrayList<int[]>> hm = new HashMap<>();
		//Integer(key) : 해당 행성, int[0] : 연결된 플로우 위치 [1] : 비용. 
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			ArrayList<int[]> list = new ArrayList<>();
			for (int j = 1; j <= n; j++) {
				int v = Integer.parseInt(st.nextToken());
				if (i == j) continue;
				int[] tmp = {j, v};
				list.add(tmp);
			}
			hm.put(i, list);
		}
		
		PriorityQueue<int[]> qu = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1]; 
			}
		});
		
		boolean[] vis = new boolean[n+1];
		int cnt = 0; 
		int cnt_vis = 1; //방문 정점 갯수.
		vis[1] = true; 
		ArrayList<int[]> list = hm.get(1);
		for (int[] l : list) qu.add(l);
		
		while (cnt_vis < n) {
			int[] q = qu.poll();
			while (vis[q[0]]) q = qu.poll();
			vis[q[0]] = true;
			cnt += q[1];
			cnt_vis++;
			
			list = hm.get(q[0]);
			for (int[] l : list) {
				if (vis[l[0]]) continue;
				qu.add(l);
				
			}
		}
		System.out.println(cnt);
		
		
	}
}
