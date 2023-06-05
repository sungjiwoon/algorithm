package b_26_mst;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

/* 최소 스패닝 트리 (골4)
 * 크루스칼 알고리즘 
 * 유니온 파인드 이용. 
 */
public class B_1197_kruskal {
	static int[][] graph;
	static int[] parent; //각 노드의 부모. 
	static int cnt; //최종 비용. 
	private static int find(int x) {
		if (parent[x] == x) return x; 
		return parent[x] = find(parent[x]);
	}
	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		/* 같은 값 바라봐야하기 때문에!! */
		if (x > y) parent[x] = y;
		else parent[y] = x;
	}
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		graph = new int[e][3]; // 노드 1, 노드 2, 비용. 
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			graph[i][0] = Integer.parseInt(st.nextToken());
			graph[i][1] = Integer.parseInt(st.nextToken());
			graph[i][2] = Integer.parseInt(st.nextToken());
		}
		
		parent = new int[v];
		cnt = 0;
		
		//비용 기준으로 오름차순 정렬. 
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
		
		//낮은 비용부터 크루스칼 알고리즘. 
		for (int i = 0; i < e; i++) {
			if (find(graph[i][0] - 1) != find(graph[i][1] - 1)) {
//				System.out.println("< 선택된 간선  > ");
//				System.out.println(Arrays.toString(graph[i]));
				union(graph[i][0] - 1, graph[i][1] - 1);
				cnt += graph[i][2];
//				System.out.println("<각 노드가 가리키고 있는 부모>");
//				System.out.println(Arrays.toString(parent) + "\n");
				continue;
			}
		}
		System.out.println(cnt);
		
	}
}




