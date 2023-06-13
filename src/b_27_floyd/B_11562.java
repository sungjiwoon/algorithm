package b_27_floyd;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
/*
 * 백양로 브레이크 (골3)
 * 플로이드 워샬
 * 
 */
public class B_11562 {
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n+1][n+1]; 
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j] = 10000;
			}
			map[i][i] = 0;
		}
		
		
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[u][v] = 0; //길도 있고 지날수도 있음.  : 0 
			if (b == 1) {				
				map[v][u] = 0; //길도 있고 지날수도 있는 방향 : 0
			} else {
				map[v][u] = 1; //길은 있지만 지날 수 없는 방향 : 1
			}
		}
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					//i -> j 로 갈수 있는 지. i -> 
	
					map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
					
				}
			}
		}
		
		
		
		int k = Integer.parseInt(br.readLine()); //질문 수. 
		StringBuilder sb = new StringBuilder();
		while (k-- > 0 ) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			sb.append(map[s][e]+"\n");
		}
		
		System.out.println(sb);
		
	}
}
