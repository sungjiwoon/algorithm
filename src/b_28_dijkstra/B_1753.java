package b_28_dijkstra;

import java.io.*;
import java.util.*;


/*
 * �ִ� ��� 1753 
 * ���ͽ�Ʈ�� �˰��� 
 * �켱���� ť �̿�. 
 */



class Pair {
	int x, y;
	Pair(int x, int y) {
		this.x = x; //���
		this.y = y; //���� ��ȣ 
	}
}
public class B_1753 {
	
	static final int INF = Integer.MAX_VALUE;
	static ArrayList<Pair>[] adj = new ArrayList[20005];
	static int[] d = new int[20005]; //�ִ� �Ÿ� ���̺� 
	
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st= new StringTokenizer(br.readLine(), " ");
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
			
		for (int i = 1; i <= v; i++) {
			d[i] = INF;
			adj[i] = new ArrayList<Pair>();
		}
		
		int k = Integer.parseInt(br.readLine()); //���� ����. 
		
		while (e-- > 0) {
			st= new StringTokenizer(br.readLine(), " ");
			int ui = Integer.parseInt(st.nextToken());
			int vi = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adj[ui].add(new Pair(w, vi)); //index ������ ���ĵǹǷ�, w�� ���� ���̸� �����ο´�.
			
		}
		
		PriorityQueue<Pair> qu = new PriorityQueue<>(new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub
				if (o1.x == o2.x) return 0;
				return o1.x - o2.x; //��� �� �������� ���� 
			}	
		});
		
		d[k] = 0; 
		qu.add(new Pair(d[k], k));
		
		while (!qu.isEmpty()) {
			Pair q = qu.poll();
			//if (d[q.y] != q.x) continue;
			for (Pair nxt : adj[q.y]) { // q.y�� ����� �������� ����. 
				if (d[nxt.y] <= d[q.y]+nxt.x) continue;
				d[nxt.y] = d[q.y] + nxt.x;
				qu.add(new Pair(d[nxt.y], nxt.y));
			}
		}
		
		for (int i = 1; i <= v; i++) {
			if (d[i] == INF) System.out.println("INF");
			else System.out.println(d[i]);
		}
		
		
		
	}
}














