package b_27_floyd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 플로이드 알고리즘을 이용한 경로복원 알고리즘 !!!
 * 난이도 골드 2
 */
public class B_11780 {
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		long[][] bus = new long[n+1][n+1];
		int[][] nxt = new int[n+1][n+1];
		
		for (int i = 0; i <= n; i++) 
			for (int j = 0; j <= n; j++) 
				bus[i][j] = Integer.MAX_VALUE;
		
		while (m-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			bus[a][b] = Math.min(c, bus[a][b]);
			nxt[a][b] = b;
		}
		
		for (int i = 1; i <= n; i++) bus[i][i] = 0;
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (bus[i][k] + bus[k][j] < bus[i][j]) {
						bus[i][j] = bus[i][k] + bus[k][j];
						nxt[i][j] = nxt[i][k];
					}
				}
			}
		}
		
		/* 최소 경로 출력 */
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				long v = bus[i][j];
				if (bus[i][j] == Integer.MAX_VALUE) v = 0;
				System.out.print(v + " ");
			}
			System.out.println();
		}
		
		/* 경로 추적기 */
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (bus[i][j] == 0 || bus[i][j] == Integer.MAX_VALUE) {
					System.out.println("0");
					continue;
				}
				
				ArrayList<Integer> path = new ArrayList<>();
				int start = i;
				while (start != j) {
					path.add(start);
					start = nxt[start][j];
				}
				path.add(j);
				System.out.print(path.size() + " ");
				for (int p : path) System.out.print(p + " ");	
				System.out.println();
			}
		}
		
	}
}





