package b_13_simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//못 풀겠다 꾀꼬리
//건너뜀.
public class B_18808 {
	static int n, m, k;
	static int[][] map = new int[42][42];
	static int[][] sti = new int[12][12];
//	static int[][] sti_copy = new int[12][12];
	static int ri=0, ci=0;
	private static boolean attach(int x, int y) {
		
		for (int r = 0; r < ri; r++) {
			for (int c = 0; c < ci; c++) {
				if (sti[r][c] == 1 && map[x+r][y+c] == 1) return false;
			}
		}
		
		for (int r = 0; r < ri; r++) {
			for (int c = 0; c < ci; c++) {
				map[r+x][c+y] = sti[r][c];
			}
		}
		return true;				
			
		
	}
	private static void swap() {
		int tmp = ri;
		ri = ci;
		ci = tmp;
	}
	private static void rotate() {
		int[][] copy = new int[12][12];
		for (int r = 0; r < ri; r++) {
			for (int c = 0; c < ci; c++) {
				copy[r][c] = sti[r][c];
			}
		}
		
		for (int c = 0; c < ci; c++) {
			for (int r = 0; r < ri; r++) {
				sti[c][r] = copy[ri-r-1][c];
			}
		}
		swap();
	}	
	
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		/* 선언 및 초기화 부분 */
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			ri = Integer.parseInt(st.nextToken());
			ci = Integer.parseInt(st.nextToken());
			
			for (int r = 0; r < ri; r++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < ci; c++) {
					sti[r][c] = Integer.parseInt(st.nextToken());
				}
			}		
		
			for (int rot = 0; rot < 4; rot++) {
				boolean is_attach = false;
				for (int x = 0; x <= n-ri; x++) {
					if (is_attach) break;
					for (int y = 0; y <= m-ci; y++) {
						if (attach(x,y)) {
							is_attach = true;
							break;
						}
					}
				}
				
				if (is_attach) break;
				rotate();				
			}
			
		}
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j]==0) cnt++;
				System.out.print(map[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println(cnt);
		
	}
}
