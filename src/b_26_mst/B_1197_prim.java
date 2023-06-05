package b_26_mst;

import java.io.*;
import java.util.*;

/*
 * ���� �˰��� �̿���.
 * �켱����ť !!!!!!!!!
 * 
 */

class Pair {
	int v; //����.
	int c; //����ġ
	Pair(int v, int c) {
		this.v = v;
		this.c = c;
	}
}
public class B_1197_prim {
	
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		HashMap<Integer, ArrayList<Pair>> hm = new HashMap<>();
		for (int i = 1; i <= V; i++) {
			hm.put(i, new ArrayList<Pair>());
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken()); //����ġ
			
			ArrayList<Pair> list = hm.get(a);
			list.add(new Pair(b, c));
			hm.put(a, list);
			
			list = hm.get(b);
			list.add(new Pair(a, c));
			hm.put(b, list);
		}
		
		//��� ������ ���� �ϵ��� �켱���� ť ����. 
		PriorityQueue<Pair> qu = new PriorityQueue<>(new Comparator<Pair>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				return p1.c - p2.c;
			}
		});
		
		boolean[] vis = new boolean[V+1]; //�湮�� ������.
		vis[1] = true;
		ArrayList<Pair> list = hm.get(1);
		for (Pair p : list) {
			qu.add(p);
		}
		
		int cnt = 0; //���� ����� ��. 
		int cnt_v = 1; //�湮�� ������ ��. V���� �������� �ݺ����� �����. 
		while (cnt_v != V) {
			
			Pair p = qu.poll();
			while (vis[p.v]) p = qu.poll();
			cnt += p.c;
			vis[p.v]= true;
			cnt_v++;
			
			list = hm.get(p.v);
			for (Pair tmp : list) {
				if (!vis[tmp.v]) qu.add(tmp);
			}
			
		}
		System.out.println(cnt);
		
		
	}
}
