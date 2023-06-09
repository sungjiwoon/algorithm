package b_26_mst;

import java.io.*;
import java.util.*;
/*
 * �����
 * ��� 2
 * ������ ���� ä��� �����, ������ ������ ���� ����� �����Ѵ�. 
 */
public class B_1368 {

	public void work() throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		//���� �ٸ� ��� ������ �ʿ� ����, �� ���� ������ ��!!!
		
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
		
		ArrayList<int[]> solo = hm.get(n+1); //ȥ�� ���� ����� ��. 
		for (int i = 1; i <= n; i++) {
			int[] tmp = {i, cost[i]};
			solo.add(tmp);
		}
		hm.put(n+1, solo);
		
		//�켱���� ť : �ּڰ� �����ϴ�. 
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









