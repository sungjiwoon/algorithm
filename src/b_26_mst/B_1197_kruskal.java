package b_26_mst;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

/* �ּ� ���д� Ʈ�� (��4)
 * ũ�罺Į �˰��� 
 * ���Ͽ� ���ε� �̿�. 
 */
public class B_1197_kruskal {
	static int[][] graph;
	static int[] parent; //�� ����� �θ�. 
	static int cnt; //���� ���. 
	private static int find(int x) {
		if (parent[x] == x) return x; 
		return parent[x] = find(parent[x]);
	}
	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		/* ���� �� �ٶ�����ϱ� ������!! */
		if (x > y) parent[x] = y;
		else parent[y] = x;
	}
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		graph = new int[e][3]; // ��� 1, ��� 2, ���. 
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			graph[i][0] = Integer.parseInt(st.nextToken());
			graph[i][1] = Integer.parseInt(st.nextToken());
			graph[i][2] = Integer.parseInt(st.nextToken());
		}
		
		parent = new int[v];
		cnt = 0;
		
		//��� �������� �������� ����. 
//		Arrays.sort(graph, (o1, o2) -> Integer.compare(o1[2], o2[2]));
		Arrays.sort(graph, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});
		
		for (int i = 0; i < v; i++) {
			parent[i] = i;
		}
		
		//���� ������ ũ�罺Į �˰���. 
		for (int i = 0; i < e; i++) {
			if (find(graph[i][0] - 1) != find(graph[i][1] - 1)) {
//				System.out.println("< ���õ� ����  > ");
//				System.out.println(Arrays.toString(graph[i]));
				union(graph[i][0] - 1, graph[i][1] - 1);
				cnt += graph[i][2];
//				System.out.println("<�� ��尡 ����Ű�� �ִ� �θ�>");
//				System.out.println(Arrays.toString(parent) + "\n");
				continue;
			}
		}
		System.out.println(cnt);
		
	}
}




