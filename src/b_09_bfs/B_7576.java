package b_09_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_7576 {
	static boolean[][] visited = new boolean[10001][1001];
	static int[][] borad = new int[1001][1001];
	static int[][] dis = new int[1001][1001];
	static Queue<Pair> qu;
	static int n, m;
	public void work() throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		//기본 세팅 변수 넣기.
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				borad[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		qu = new LinkedList<>();
		for (int[] d : dis) {
			Arrays.fill(d, -1);
		}
		
		//시작 !!!!
		
		// 1단계 큐에 넣는 작업. 
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (borad[i][j] <= 0) continue; //토마토가 아에 익지 않았다거나, 없으면 반복문 진행 X
				
				if (borad[i][j] == 1) {
					qu.offer(new Pair(i, j));
					dis[i][j] = 0; //익었다는 것은 앞으로 익을 날짜가 없으므로 0 세팅. 
				}
			}
		}

		while (!qu.isEmpty()) {
			Pair p = qu.poll();
			for (int k = 0; k < 4; k++) {
				int dx_x = p.X+dx[k];
				int dy_y = p.Y+dy[k];
						
				if (dx_x < 0 || dx_x >= m || dy_y < 0 || dy_y >= n) continue; //배열 범위 밖이면 X

				if (borad[dx_x][dy_y] > -1 && dis[dx_x][dy_y] == -1) {
					dis[dx_x][dy_y] = dis[p.X][p.Y] + 1;
					qu.offer(new Pair(dx_x, dy_y));
				
				}
			}
		}
		
		int result = 0;
		for (int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++ ) {
				if (borad[i][j] == 0 && dis[i][j] == -1) {
					result = -1;
					break;
				}
				result = Math.max(dis[i][j], result);
			}
			
			if (result == -1) break;
		}
		System.out.println(result);
		
		
	}
}
