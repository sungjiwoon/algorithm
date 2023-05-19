import java.io.*;
import java.util.*;
import java.util.Map.Entry;


public class Main {
	static int n, cnt = 0;
	static int[][] graph;
	static int[] arr;
	
	private static void dfs(int depth, int index) {
		if (depth > 2) return;
		
		for (int i = 2; i <= n; i++) {
			if (graph[index][i] == 1) {
				System.out.println(index + " " + i + ", depth :" + depth);
				arr[i] = Math.min(depth, arr[i]);
				
				dfs(depth+1, i);

			}
		}
		
	}
	public static void main(String[] args) throws Exception {		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		graph = new int[n+1][n+1];
		for (int i = 1; i <= m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = graph[b][a] = 1;
		}
		arr = new int[n+1];
		Arrays.fill(arr, 501);
		dfs(1, 1);
		
		for (int i = 2; i <= n; i++) {
			if (arr[i] < 3) cnt++;
		}
		System.out.println(cnt);
		
	}
	
}
