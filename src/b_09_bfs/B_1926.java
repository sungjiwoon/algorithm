package b_09_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * �ǹ� 1
 * BFS �⺻ ���� ���� ����.
 * ���� : 
 * � ū ��ȭ���� �׸��� �׷��� ���� ��, �� �׸��� ������, 
 * �� �׸� �� ���̰� ���� ���� ���� ���̸� ����Ͽ���. 
 * ��, �׸��̶�� ���� 1�� ����� ���� �� �׸��̶�� ��������. 
 * ���γ� ���η� ����� ���� ������ �� ���̰� �밢������ ������ �� ���� ������ �׸��̴�. 
 * �׸��� ���̶� �׸��� ���Ե� 1�� �����̴�.
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
		
		//�迭�� ����.
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				borad[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		qu = new LinkedList<>();
		//����.
		int count = 0;
		int area = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (borad[i][j] == 0 || visited[i][j]) {
					continue; //��ĥ�� �ȵưų� �湮������ pass
				}
				count++; //1�̰�, �湮�� ���� �ʾ����Ƿ� �������� ��.
				qu.offer(new Pair(i, j));
				visited[i][j] = true;
				area = 0; //0 �̸� �׸��� �������Ƿ�
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
















