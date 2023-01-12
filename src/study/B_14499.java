package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_14499 {
	static int N, M, x, y, K;
	static int[][] map;
	static int[] comm;
	static int[] dice = new int[7];
	static int[] dx = {0,0,0,-1,1}, dy = {0,1,-1,0,0};
	
	private static void move1() { //동쪽
		int tmp = dice[4];
		dice[4] = dice[6];
		dice[6] = dice[3];
		dice[3] = dice[1];
		dice[1] = tmp;
		
	}
	private static void move2() { //서쪽
		int tmp = dice[3];
		dice[3] = dice[6];
		dice[6] = dice[4];
		dice[4] = dice[1];
		dice[1] = tmp;
	}
	private static void move3() { //북쪽
		int tmp = dice[1];
		dice[1] = dice[2];
		dice[2] = dice[6];
		dice[6] = dice[5];
		dice[5] = tmp;
	}
	private static void move4() { //남쪽
		int tmp = dice[2];
		dice[2] = dice[1];
		dice[1] = dice[5];
		dice[5] = dice[6];
		dice[6] = tmp;
	}
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		/* 선언 및 초기화 부분 */
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		comm = new int[K];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < K; i++) {
			comm[i] = Integer.parseInt(st.nextToken());
		}
		//Arrays.fill(dice, 0);
		
		//System.out.println(Arrays.deepToString(map));
		
		/* 시작 ! */
		
		for (int i = 0; i < K; i++) {
			x += dx[comm[i]];
			y += dy[comm[i]]; 
			if (x >= N || x < 0 || y >= M || y < 0 ) {
				x -= dx[comm[i]];
				y -= dy[comm[i]]; 
				continue;
			}
			
			if (comm[i] == 1) {
				move1();
			} else if (comm[i] == 2) {
				move2();
			} else if (comm[i] == 3) {
				move3();
			} else if (comm[i] == 4) {
				move4();
			}
			
			//하단은 6 반환
			if (map[x][y] == 0) {
				map[x][y] = dice[6];
			} else {
				dice[6] = map[x][y];
				map[x][y] = 0;
			}
			
			//상단은 맨위 1
			sb.append(dice[1]+"\n");
			
			
			
		}	
		System.out.println(sb);
		
		
		
	}
}
