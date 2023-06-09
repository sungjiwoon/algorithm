package b_26_mst;

import java.io.*;
import java.util.*;
/*
 * 물대기
 * 골드 2
 * 스스로 물을 채우는 경우라면, 임의의 정점을 새로 만들어 측정한다. 
 */
public class B_1368 {

	public void work() throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		//굳이 다른 논과 연결할 필요 없고, 논에 물이 있으면 됨!!!
		
		int[] cost = new int[n+1];
		for (int i = 1; i <= n; i++) {
			cost[i] = Integer.parseInt(br.readLine());
		}
		
		
		HashMap<Integer, ArrayList<int[]>> hm = new HashMap<>();
		for (int i = 1; i <= n+1; i++) {
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
			int[] tmp = {n+1, cost[i]};
			list.add(tmp);
			hm.put(i, list);
		}
		
		ArrayList<int[]> solo = hm.get(n+1); //혼자 물을 덧대는 곳. 
		for (int i = 1; i <= n; i++) {
			int[] tmp = {i, cost[i]};
			solo.add(tmp);
		}
		hm.put(n+1, solo);
		
		//우선순위 큐 : 최솟값 정렬하는. 
		PriorityQueue<int[]> qu = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1]-o2[1];
			}
		});
		
		
		ArrayList<int[]> list = hm.get(n+1);
		for (int[] l : list) {
			qu.add(l);
		}
		
		int cnt = 1;
		long ans = 0;
		boolean[] vis = new boolean[n+2];
		vis[n+1] = true;
		
		while (cnt <= n) {
			int[] q = qu.poll();
			while (vis[q[0]]) q = qu.poll();

			vis[q[0]] = true;
			cnt++;
			ans += q[1];
			list = hm.get(q[0]);
			for (int[] l : list) {
				if (vis[l[0]]) continue;
				qu.add(l);
			}
			
		}
		System.out.println(ans);
		
	}
}









