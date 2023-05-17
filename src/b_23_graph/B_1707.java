package b_23_graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1707 {
	static int n,m;
	static int[][] arr;
	static boolean[] vis;
	static int res = 0;
	private static void dfs(int index, StringBuilder sb) {
		if (vis[index]) return;
		
		vis[index] = true;
		sb.append(index + " ");
		for (int i =  1; i <= n; i++) {
			if (!vis[i] && arr[index][i] == 1) {
				dfs(i, sb);
			}
		}
		
	}
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); //tc ¼ö
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			arr = new int[n+1][n+1];
			vis = new boolean[n+1];
			for (int e = 0; e < E; e++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a][b] = arr[b][a] = 1;
			}
			int res = 0;
			for (int i = 1; i <= n; i++) {
				if (!vis[i]) {
					dfs(i, sb);
					res++;
					sb.append("\n");
					if (res > 2) break;
				}
			}
			
			if (res == 2) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
			
		}	
		System.out.println(sb);
		
		
	}
}
