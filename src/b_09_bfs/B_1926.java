package b_09_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 실버 1
 * BFS 기본 연습 문제 수준.
 * 문제 : 
 * 어떤 큰 도화지에 그림이 그려져 있을 때, 그 그림의 개수와, 
 * 그 그림 중 넓이가 가장 넓은 것의 넓이를 출력하여라. 
 * 단, 그림이라는 것은 1로 연결된 것을 한 그림이라고 정의하자. 
 * 가로나 세로로 연결된 것은 연결이 된 것이고 대각선으로 연결이 된 것은 떨어진 그림이다. 
 * 그림의 넓이란 그림에 포함된 1의 개수이다.
 */

public class B_1926 {
	static boolean visited[][] = new boolean[502][502];
	static int borad[][] = new int[502][502];
	static int m, n;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	static Queue<Pair> qu;
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		//배열값 셋팅.
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				borad[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		qu = new LinkedList<>();
		//시작.
		int count = 0;
		int area = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (borad[i][j] == 0 || visited[i][j]) {
					continue; //색칠이 안됐거나 방문했을때 pass
				}
				count++; //1이고, 방문을 하지 않았으므로 시작점이 됨.
				qu.offer(new Pair(i, j));
				visited[i][j] = true;
				area = 0; //0 이면 그림이 끊겼으므로
				while (!qu.isEmpty()) {
					Pair p = qu.poll();
					area++;
					//System.out.println(p.X + " " + p.Y);
					for (int k = 0; k < 4; k++) {
						int n_x = p.X + dx[k];
						int n_y = p.Y + dy[k];
						if (n_x < 0 || n_x >= n || n_y < 0 || n_y >= m) continue;
						if (borad[n_x][n_y] == 1 && !visited[n_x][n_y]) {
							qu.offer(new Pair(n_x, n_y));
							
							visited[n_x][n_y] = true;
						}
					}
				}
				if (area > max) max = area;
				System.out.println();
				
			}
		}
		System.out.println(count);
		System.out.println(max);
		
		
	}
}
















