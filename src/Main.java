import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {	
	static int[] parent;
	private static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		parent[y] = x;
	}
	public static void main(String[] args) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] graph = new int[m][3];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			graph[i][0] = Integer.parseInt(st.nextToken());
			graph[i][1] = Integer.parseInt(st.nextToken());
			graph[i][2] = Integer.parseInt(st.nextToken());
		}
		
		//비용 정렬.
		Arrays.sort(graph, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});
	
		
		parent = new int[n+1];
		for (int i = 1; i <= n; i++) parent[i] = i;
		
		long ans = 0; //최종비용. 
		int cnt_vis = 0; 
		for (int i = 0; i < m; i++) {
			if (find(graph[i][0]) != find(graph[i][1])) {
				union(graph[i][0], graph[i][1]);
				
				cnt_vis++;
				ans += graph[i][2];
				//System.out.println(graph[i][0] + " " + graph[i][1] + " : " + graph[i][2]);
				if (cnt_vis == n-2) break;
			}
		}
		System.out.println(ans);
	}
}
