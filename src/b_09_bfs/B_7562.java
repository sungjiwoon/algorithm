package b_09_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * �ǹ� 1 : ���� ȥ�� Ǯ����!
 * ����
	ü���� ���� �� ����Ʈ�� ������ �ִ�. ����Ʈ�� �� ���� �̵��� �� �ִ� ĭ�� �Ʒ� �׸��� �����ִ�. 
	����Ʈ�� �̵��Ϸ��� �ϴ� ĭ�� �־�����. ����Ʈ�� �� �� �����̸� �� ĭ���� �̵��� �� ������?	
	
	�Է�
	�Է��� ù° �ٿ��� �׽�Ʈ ���̽��� ������ �־�����.	
	�� �׽�Ʈ ���̽��� �� �ٷ� �̷���� �ִ�. ù° �ٿ��� ü������ �� ���� ���� l(4 �� l �� 300)�� �־�����. 
	ü������ ũ��� l �� l�̴�. ü������ �� ĭ�� �� ���� �� {0, ..., l-1} �� {0, ..., l-1}�� ��Ÿ�� �� �ִ�.
	��° �ٰ� ��° �ٿ��� ����Ʈ�� ���� �ִ� ĭ, ����Ʈ�� �̵��Ϸ��� �ϴ� ĭ�� �־�����.
	
	���
	�� �׽�Ʈ ���̽����� ����Ʈ�� �ּ� �� ������ �̵��� �� �ִ��� ����Ѵ�.
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
