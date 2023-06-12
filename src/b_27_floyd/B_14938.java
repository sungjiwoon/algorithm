package b_27_floyd;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
/*
 * 서강그라운드 (골드 4)
 * 플로이드 알고리즘 이용. 
 */
public class B_14938 {
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		int[] items = new int[n+1];
		int[][] map = new int[n+1][n+1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) items[i] = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.MAX_VALUE/2;
			}
			map[i][i] = 0;
		}
		
		while (r-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			map[a][b] = map[b][a] = l;
		}
		
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
				}
			}
		}
		
		/* 정점 하나를 기준으로 두고 어느 정점에 가는 것이 가장 최솟값인지 판단. */
		int ans = 0;
		int max = 0;
		for (int i = 1; i <= n; i++) {
			max = 0;
			for (int j = 1; j <= n; j++) {
				if (map[i][j] <= m) max += items[j];
			}
			ans = Math.max(max, ans);
		}
		System.out.println(ans);
		
	}
}
