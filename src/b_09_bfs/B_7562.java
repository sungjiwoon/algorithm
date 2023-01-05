package b_09_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 실버 1 : 드디어 혼자 풀었당!
 * 문제
	체스판 위에 한 나이트가 놓여져 있다. 나이트가 한 번에 이동할 수 있는 칸은 아래 그림에 나와있다. 
	나이트가 이동하려고 하는 칸이 주어진다. 나이트는 몇 번 움직이면 이 칸으로 이동할 수 있을까?	
	
	입력
	입력의 첫째 줄에는 테스트 케이스의 개수가 주어진다.	
	각 테스트 케이스는 세 줄로 이루어져 있다. 첫째 줄에는 체스판의 한 변의 길이 l(4 ≤ l ≤ 300)이 주어진다. 
	체스판의 크기는 l × l이다. 체스판의 각 칸은 두 수의 쌍 {0, ..., l-1} × {0, ..., l-1}로 나타낼 수 있다.
	둘째 줄과 셋째 줄에는 나이트가 현재 있는 칸, 나이트가 이동하려고 하는 칸이 주어진다.
	
	출력
	각 테스트 케이스마다 나이트가 최소 몇 번만에 이동할 수 있는지 출력한다.
 * 
 */
public class B_7562 {
	static int T, L;
	static Queue<Pair> qu;
	static int[][] dis;
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		T = Integer.parseInt(br.readLine());
		
		int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
		int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
		
		for (int t = 0; t < T; t++) {
			L = Integer.parseInt(br.readLine());			
			dis = new int[L][L];
			for (int[] d: dis) Arrays.fill(d, -1);
			qu = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			
			if (sx != ex || sy != ey)
				qu.offer(new Pair(sx, sy));
			dis[sx][sy]=0;
			boolean isOk = false;
			
			while (!qu.isEmpty()) {
				Pair p = qu.poll();
				for (int k = 0; k < 8; k++) {
					int xx = p.X + dx[k];
					int yy = p.Y + dy[k];
					if (xx >= L || xx < 0 || yy >= L || yy < 0) continue;
					if (xx == ex && yy == ey) {
						isOk = true;
						dis[ex][ey] = dis[p.X][p.Y]+1;
						break;
					}
					if (dis[xx][yy] == -1) {
						dis[xx][yy] = dis[p.X][p.Y]+1;
						qu.offer(new Pair(xx,yy));
					}
				}
				if (isOk) break;
			}
			sb.append(dis[ex][ey]+"\n");
		}
		System.out.println(sb);	

		
	}
}
