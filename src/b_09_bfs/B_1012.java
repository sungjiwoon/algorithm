package b_09_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 
 * �ǹ� 2 BFS ���� 
 * ������ ������ �ѳ��� ������ �������� ����� ���߸� ����ϱ�� �Ͽ���. ����� ���� �ʰ� ���߸� ����Ϸ��� ���߸� �������κ��� ��ȣ�ϴ� ���� �߿��ϱ� ������, 
 * �ѳ��� ���� ������ ȿ������ �����������̸� �����ϱ�� ����Ѵ�. �� �����̴� ���߱�ó�� �����ϸ� ������ ��� �������ν� ���߸� ��ȣ�Ѵ�.
 *  Ư��, � ���߿� �����������̰� �� ������ ��� ������ �� �����̴� ������ �ٸ� ���߷� �̵��� �� �־�, �� ���ߵ� ���� �������κ��� ��ȣ���� �� �ִ�. 
 *  �� ������ �����¿� �� ���⿡ �ٸ� ���߰� ��ġ�� ��쿡 ���� �������ִ� ���̴�.

	�ѳ��� ���߸� ����ϴ� ���� ���� ���ؼ� ���߸� �������� �ɾ� ���Ҵ�. ���ߵ��� ���ִ� ������ �����������̰� �� ������ ������ �ǹǷ� 
	���� �������ִ� ���ߵ��� �� ������ �����ִ��� �����ϸ� �� �� ������ �����̰� �ʿ����� �� �� �ִ�. 
	���� ��� ���߹��� �Ʒ��� ���� �����Ǿ� ������ �ּ� 5������ �����������̰� �ʿ��ϴ�. 
	0�� ���߰� �ɾ��� ���� ���� ���̰�, 1�� ���߰� �ɾ��� �ִ� ���� ��Ÿ����.
	
	1	1	0	0	0	0	0	0	0	0
	0	1	0	0	0	0	0	0	0	0
	0	0	0	0	1	0	0	0	0	0
	0	0	0	0	1	0	0	0	0	0
	0	0	1	1	0	0	0	1	1	1
	0	0	0	0	1	0	0	1	1	1
	�Է�
	�Է��� ù �ٿ��� �׽�Ʈ ���̽��� ���� T�� �־�����. �� ���� �ٺ��� ������ �׽�Ʈ ���̽��� ���� ù° �ٿ���
	 ���߸� ���� ���߹��� ���α��� M(1 �� M �� 50)�� ���α��� N(1 �� N �� 50), 
	 �׸��� ���߰� �ɾ��� �ִ� ��ġ�� ���� K(1 �� K �� 2500)�� �־�����. 
	 �� ���� K�ٿ��� ������ ��ġ X(0 �� X �� M-1), Y(0 �� Y �� N-1)�� �־�����. �� ������ ��ġ�� ���� ���� ����.
	
	���
	�� �׽�Ʈ ���̽��� ���� �ʿ��� �ּ��� ������������ ���� ���� ����Ѵ�.
 */
public class B_1012 {
	static int T, N, M, K;
	static int[][] borad;
	static Queue<Pair> qu;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		T = Integer.parseInt(br.readLine());
	
		for (int t = 0; t < T; t++) {			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			borad = new int[N][M];
			visited = new boolean[N][M];
			for (int[] b : borad) {
				Arrays.fill(b, 0);
			}
			
			
			for (int k = 0; k < K; k++) { 
				st = new StringTokenizer(br.readLine(), " ");
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				
				borad[j][i] = 1;
							
			}
			
			qu = new LinkedList<>();
			int area = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (borad[i][j] == 0 || visited[i][j] ) continue; // 0�̰ų� �湮 ������ �ݺ��� �ǳʶٱ�.
					area++;
					qu.offer(new Pair(i, j));
					visited[i][j] = true;
					
					while (!qu.isEmpty()) {
						Pair p = qu.poll();
						for (int k = 0; k < 4; k++) {
							int xx = p.X+dx[k];
							int yy = p.Y+dy[k];
							
							if (xx < 0 || xx >= N || yy < 0 || yy >= M) continue;
							if (!visited[xx][yy] && borad[xx][yy]==1) {
								qu.offer(new Pair(xx, yy));
								visited[xx][yy] = true;
//								System.out.println("-> " + xx+" " + yy);
							}
						}
					}
//					System.out.println(area + " --- ");
					
					 //�ϳ��� �׸� ������ �������Ƿ�. 
				}
			}
			System.out.println(area);
		}
	
	}
}
