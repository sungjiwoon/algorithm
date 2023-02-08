import java.io.*;
import java.util.*;

import b_13_simulation.Pair;

public class Main {
	//이해못함 걍 포기~
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		/* 선언 및 초기화 부분 */
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[51][51];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		
		Queue<Pair> qu = new LinkedList<>();
		qu.offer(new Pair(r, c));
		
		while (!qu.isEmpty()) {
			Pair p = qu.poll();
			map[p.X][p.Y] = 2;
			int clean = 0;
			int orl = dir; //원래 dir 저장. 
			for (int k = 0; k < 4; k++) {
				dir = ( dir + 3 ) % 4;
				int xx = p.X + dx[dir];
				int yy = p.Y + dy[dir];
				if (xx < 0 || yy < 0 || xx >= n || yy >= m) continue;
				if (map[xx][yy] < 1 ) {
					qu.offer(new Pair(xx, yy));
					break;
				}
				clean++;
			}
			if (clean == 4) {
				int rev = (orl + 2) % 4;
				int xx = p.X + dx[rev];
				int yy = p.Y + dy[rev];
				if (xx < 0 || yy < 0 || xx >= n || yy >= m) break;
				if (map[xx][yy] != 1) {
					qu.offer(new Pair(xx, yy));
				} else {
					break;
				}
			}
		}
		int cnt = 0; //청소하는 칸의 갯수 
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 2) cnt++;
			}
		}
		System.out.println(cnt);
		
	}
	
}
