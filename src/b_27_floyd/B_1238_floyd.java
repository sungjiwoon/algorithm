package b_27_floyd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1238 문제 플로이드로 풀었음. 
public class B_1238_floyd {
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		int[][] d = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				d[i][j] = 100000;
			}
			d[i][i] = 0;
		}
		
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			d[i][j] = t;
			
		}
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					d[i][j] = Math.min(d[i][j], d[i][k]+d[k][j]);
				}
			}
		}
		
		int max = 0;
		for (int i = 1; i <= n; i++) {
			if (i == x) continue;
			max = Math.max(max, d[i][x] + d[x][i]);
			System.out.println(i + " " + d[i][x] + " " + d[x][i]);
		}
		System.out.println(max);
		
	}
}




