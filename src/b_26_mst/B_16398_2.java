package b_26_mst;

import java.io.*;
import java.util.*;

//크루스칼 버전! :: 계속 실패 뜸 ㅡㅡ 
public class B_16398_2 {
	static int[] parent;
	private static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x > y) parent[x] = y;
		else parent[y] = x;
	}
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[][] graph = new int[n*n][3]; // 0,1 : 정점, 2; 비용. 
		int k = 1;
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			ArrayList<int[]> list = new ArrayList<>();
			for (int j = 1; j <= n; j++) {
				int v = Integer.parseInt(st.nextToken());
				if (i == j) continue;
				graph[k][0] = i;
				graph[k][1] = j;
				graph[k++][2] =v;
			}
		}
		
		Arrays.sort(graph, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		//System.out.println(Arrays.deepToString(graph));
		parent = new int[n+1];
		for (int i = 1; i<= n; i++) parent[i] = i;
		long cnt = 0;
		int cnt_vis = 0;
		for (int i = 1; i < k; i++) {
			if (find(graph[i][0]) != find(graph[i][1])) {
				union(graph[i][0], graph[i][1]);
				cnt+= graph[i][2];
				cnt_vis++;
				if (cnt_vis == n-1) break;
			}
			
		}
		
		System.out.println(cnt);
		
		
	}
}






