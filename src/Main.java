import java.io.*;
import java.util.*;
import java.util.Map.Entry;


public class Main {
	static int[][] arr;
	static boolean[] vis;
	static int n, m, res = 0;
	static StringBuilder sb = new StringBuilder();
	private static void dfs(int index) {
		
		if (vis[index]) return;
		
		vis[index] = true;
		for (int i = 1; i <= n; i++) {
			if (arr[index][i] == 1) {				
				dfs(i);
			}
		}
		
	}
	public static void main(String[] args) throws Exception {		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());		
		
		arr = new int[n+1][n+1];
		for (int i = 0; i < m; i++) {
			 st = new StringTokenizer(br.readLine(), " ");
			 int a = Integer.parseInt(st.nextToken());
			 int b = Integer.parseInt(st.nextToken());
			 arr[a][b] = arr[b][a] = 1;
		}
		
		vis = new boolean[n+1];
		//1. dfs 버전 그래프 
		for (int i = 1; i <= n; i++) {
			if (!vis[i]) {
				dfs(i);
				res++;
			}
		}
		System.out.println(res);
	}
	
}
