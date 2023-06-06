package b_26_mst;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

/*
 * �༺ ���� (���4) 
 * �ּ� ���� Ʈ�� 
 * ���� �˰������� Ǯ����!! 
 */

public class B_16398 {
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		HashMap<Integer, ArrayList<int[]>> hm = new HashMap<>();
		//Integer(key) : �ش� �༺, int[0] : ����� �÷ο� ��ġ [1] : ���. 
		
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
		int cnt_vis = 1; //�湮 ���� ����.
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
