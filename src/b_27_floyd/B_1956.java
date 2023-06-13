package b_27_floyd;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
/*
 * 플로이드 워샬 알고리즘은 최댓값 상수 값이 정말 중요하다... 
 * 운동 (골드 4) 
 */
public class B_1956 {
	static final int INF = 987987987;
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[V+1][V+1];
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				map[i][j] = INF; //c 는 10000이하임. 
			}
			map[i][i] = 0;
		}
		while (E-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken()); //걸리는 시간. 
			map[a][b] = c;
		}
		
		for (int k = 1; k <= V; k++) {
			for (int i = 1; i <= V; i++) {
				for (int j = 1; j <= V; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
				}
			}
		}
		
		//사이클 : map[i][k] + map[k][i] -> 최솟값. 
		int min = INF;
		for (int i = 1; i <= V; i++) {
			for (int j = i+1; j <= V; j++) {
				
				min = Math.min(min, map[i][j]+map[j][i]);
			}
		}
		if (min == INF) min = -1;
		System.out.println(min);
		
	}
}





