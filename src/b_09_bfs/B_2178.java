package b_09_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * BFS �⺻ ���� �ǹ� 1
 * N��Mũ���� �迭�� ǥ���Ǵ� �̷ΰ� �ִ�.

	1	0	1	1	1	1
	1	0	1	0	1	0
	1	0	1	0	1	1
	1	1	1	0	1	1
	�̷ο��� 1�� �̵��� �� �ִ� ĭ�� ��Ÿ����, 0�� �̵��� �� ���� ĭ�� ��Ÿ����. 
	�̷��� �̷ΰ� �־����� ��, (1, 1)���� ����Ͽ� (N, M)�� ��ġ�� �̵��� �� ������ �ϴ� 
	�ּ��� ĭ ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. �� ĭ���� �ٸ� ĭ���� �̵��� ��, 
	���� ������ ĭ���θ� �̵��� �� �ִ�.
	
	���� �������� 15ĭ�� ������ (N, M)�� ��ġ�� �̵��� �� �ִ�. 
	ĭ�� �� ������ ���� ��ġ�� ���� ��ġ�� �����Ѵ�.
	
	** Ǯ�� 
	*
	*dis ��� �Ÿ� 2���� �迭�� �߰� ����.
	*�湮������ ĭ���� �湮�� ĭ�� +1�� �������ν� ���� ��ġ������ �Ÿ��� �ľ��ϵ��� ��. 
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
		
		// ���� �⺻ 
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
			Arrays.fill(d, -1); //2���� �迭 ä�� �� ���̴� �Լ�. 

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
