package b_26_mst;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
/*
 * 학교 탐방하기 (골3)
 * 
 */
public class B_13418 {
	static int n;
	static HashMap<Integer, ArrayList<int[]>> hm = new HashMap<>();
	static PriorityQueue<int[]> qu;
	
	private static int func(int v) {
		boolean[] vis = new boolean[n+1];
		
		vis[v] = true;
		ArrayList<int[]> list = hm.get(v);
		for (int[] l : list) qu.add(l);
		
		int cnt = 0; //전체 방문 정점 갯수.
		int k = 0; //오르막의 갯수. 
		
		while (cnt < n) {
			
			int[] q = qu.poll();
			while (!qu.isEmpty() && vis[q[0]]) q = qu.poll();
			
			vis[q[0]] = true;
			if (q[1]==0) k++;
			cnt++;
			
			//System.out.println(q[0] + " " + q[1]);
			
			list = hm.get(q[0]);
			for (int[] l : list) {
				if (vis[l[0]]) 	continue;
				qu.add(l);
			}
		}
		
		return (int) Math.pow(k, 2);
	}
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i <= n; i++) hm.put(i, new ArrayList<int[]>());
		
		while (m-- >= 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			ArrayList<int[]> list = hm.get(x);
			int[] tmp = {y,v};
			list.add(tmp);
			hm.put(x, list);
			
			ArrayList<int[]> list2 = hm.get(y);
			int[] tmp2 = {x,v};
			list2.add(tmp2);
			hm.put(y, list2);
			
		}
		
		//최소 경로 구하기. 
		qu = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1] - o1[1];
			}
		});
		
		int k1 = func(0);
		//System.out.println(k1);
		
		//최대 경로 구하기. 
		qu = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		int k2 = func(0);
		//System.out.println(k2);
		System.out.println(k2-k1);
		
		
		
	}
}






