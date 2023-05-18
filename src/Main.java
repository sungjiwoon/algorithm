import java.io.*;
import java.util.*;
import java.util.Map.Entry;


public class Main {
	static int n;
	static int[][] arr;
	static boolean[] vis;
	static int[] res;
	private static void dfs(int index) {
		
		for (int i = 1; i <= n; i++) {
			if (index != i && arr[index][i] == 1) {
				res[i]++;
				res[index]--;
				dfs(i);
			}
		}
		
	}
	public static void main(String[] args) throws Exception {		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1][n+1];
		res = new int[n+1];
		vis = new boolean[n+1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[b][a] = 1; // a > b 
		}
		
		for (int i = 1; i <= n; i++) {
			dfs(i);
		}
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 1; i<= n; i++) {
			max = Math.max(max, res[i]);
			min = Math.min(min, res[i]);
		}
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (res[i] == min || res[i] == max) cnt++;
		}
		System.out.println(cnt);
		
	}
	
}
