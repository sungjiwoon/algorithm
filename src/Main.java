import java.io.*;
import java.util.*;


public class Main {
	static int n;
	static int[][] nums;
	static boolean[] vis;
	static int min = Integer.MAX_VALUE;
	private static void dfs (int depth, int st) {
		if (depth == n/2) {
			int ta = 0, tb = 0;
			
			for (int i = 0; i < n-1; i++) {
				for (int j = i+1; j < n; j++) {
					if (vis[i] && vis[j]) {
						ta += nums[i][j] + nums[j][i];
					} else if (!vis[i] && !vis[j]) {
						tb += nums[i][j] + nums[j][i];
					}
				}
			}
			
			if (Math.abs(ta-tb) < min) min = Math.abs(ta-tb);
			return;
		}
		
		for (int i = st; i < n; i++) {
//			if (!vis[i]) {
				vis[i] = true;
				dfs(depth+1, i+1);
				vis[i] = false;
//			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		vis = new boolean[n];
		nums = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				nums[i][j] = Integer.parseInt(s[j]);
			}

		}
		
		dfs(0,0);
		System.out.println(min);
	}
	
}
