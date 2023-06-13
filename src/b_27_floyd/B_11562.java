package b_27_floyd;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
/*
 * ���� �극��ũ (��3)
 * �÷��̵� ����
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
			
			map[u][v] = 0; //�浵 �ְ� �������� ����.  : 0 
			if (b == 1) {				
				map[v][u] = 0; //�浵 �ְ� �������� �ִ� ���� : 0
			} else {
				map[v][u] = 1; //���� ������ ���� �� ���� ���� : 1
			}
		}
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					//i -> j �� ���� �ִ� ��. i -> 
	
					map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
					
				}
			}
		}
		
		
		
		int k = Integer.parseInt(br.readLine()); //���� ��. 
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
