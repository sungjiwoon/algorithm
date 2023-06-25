package b_28_dijkstra;

import java.io.*;
import java.util.*;

class Bus {
	int v, c;
	Bus(int v, int c) {
		this.v = v;
		this.c = c;
	}
}
/*
 * 최소 비용 구하기 2
 * 골드 2
 * pre알고리즘!
 */
public class B_11779 {
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		ArrayList<Bus>[] adj = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
		
		while (m-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj[a].add(new Bus(b,c));
		}
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Bus> qu = new PriorityQueue<>(new Comparator<Bus>() {
			@Override
			public int compare(Bus b1, Bus b2) {
				return b1.c - b2.c;
			}
		});
		
		int[] d = new int[n+1];
		int[] pre = new int[n+1];
		Arrays.fill(d, 100000*1000+5);
		d[a] = 0;
		qu.add(new Bus(a, d[a]));
		
		while (!qu.isEmpty()) {
			Bus p = qu.poll();
			if (p.c != d[p.v]) continue;
			
			for (Bus nxt :adj[p.v]) {
				if (d[nxt.v] < p.c + nxt.c) continue;
				d[nxt.v] = p.c + nxt.c;
				qu.add(new Bus(nxt.v, d[nxt.v]));
				pre[nxt.v] = p.v;
			}
		}
		System.out.println(d[b]);
		
		Stack<Integer> pre_s = new Stack<>();
		int start = b;
		while (start != a) {
			pre_s.push(start);
			start = pre[start];
		}
		pre_s.add(a);
		System.out.println(pre_s.size());
		while (!pre_s.isEmpty()) {
			System.out.print(pre_s.pop() + " ");
		}
	}
}









