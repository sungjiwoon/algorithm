package b_09_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 골드 5 
 * BFS 연습 문제 빠킹독
 * 철수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다. 토마토는 아래의 그림과 같이 격자 모양 상자의 칸에 하나씩 넣어서 창고에 보관한다. 
	창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 보관 후 하루가 지나면, 
	익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다. 
	하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다.
	대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 
	철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.

	토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때,
	 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 
	 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
 */
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
