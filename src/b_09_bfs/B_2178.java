package b_09_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * BFS 기본 문제 실버 1
 * N×M크기의 배열로 표현되는 미로가 있다.

	1	0	1	1	1	1
	1	0	1	0	1	0
	1	0	1	0	1	1
	1	1	1	0	1	1
	미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 
	이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 
	최소의 칸 수를 구하는 프로그램을 작성하시오. 한 칸에서 다른 칸으로 이동할 때, 
	서로 인접한 칸으로만 이동할 수 있다.
	
	위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 
	칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
	
	** 풀이 
	*
	*dis 라는 거리 2차원 배열을 추가 선언.
	*방문예정할 칸에는 방문한 칸의 +1을 해줌으로써 기존 위치에서의 거리를 파악하도록 함. 
 */

public class B_2178 {
	static boolean[][] visited = new boolean[101][101];
	static int[][] dis = new int[101][101];
	static int[][] board = new int[101][101];
	static int n, m;
	static Queue<Pair> qu;
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 세팅 기본 
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};

		qu = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
			}
		}
		for (int d[] : dis)
			Arrays.fill(d, -1); //2차원 배열 채울 때 쓰이는 함수. 

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 0 || visited[i][j]) continue;
				qu.offer(new Pair(i, j));
				dis[i][j]++;
				while (!qu.isEmpty()) {
					Pair p = qu.poll();
					//System.out.println(p.X + " " + p.Y);
					
					for (int k = 0; k < 4; k++) {
						int dx_x = p.X + dx[k];
						int dy_y = p.Y + dy[k];
						
						if (dx_x < 0 || dx_x >= n || dy_y < 0 || dy_y >= m) continue;
						
						if (board[dx_x][dy_y] == 1 && !visited[dx_x][dy_y]) {	
							visited[dx_x][dy_y] = true; 
							qu.offer(new Pair(dx_x, dy_y));
							dis[dx_x][dy_y] = dis[p.X][p.Y] + 1;
							
							
						}
					}
				}
			}
		}
		System.out.println(dis[n-1][m-1]);
		
		
	}

}
