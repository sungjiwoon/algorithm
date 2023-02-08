package b_13_simulation;

import java.io.*;
import java.util.*;
/*
 * �κ� û�ұ� ���� (��� 5)
 
	�ð� ����	�޸� ����	����	����	���� ���	���� ����
	2 ��	512 MB	46306	25207	16897	53.747%
	����
	�κ� û�ұⰡ �־����� ��, û���ϴ� ������ ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
	�κ� û�ұⰡ �ִ� ��Ҵ� N��M ũ���� ���簢������ ��Ÿ�� �� ������, 1��1ũ���� ���簢�� ĭ���� �������� �ִ�. ������ ĭ�� �� �Ǵ� �� ĭ�̴�. û�ұ�� �ٶ󺸴� ������ ������, �� ������ ��, ��, ��, ���� �ϳ��̴�. ������ �� ĭ�� (r, c)�� ��Ÿ�� �� �ְ�, r�� �������κ��� ������ ĭ�� ����, c�� �������� ���� ������ ĭ�� �����̴�.
	
	�κ� û�ұ�� ������ ���� �۵��Ѵ�.
	
	���� ��ġ�� û���Ѵ�.
	���� ��ġ���� ���� ������ �������� ���ʹ������ ���ʴ�� Ž���� �����Ѵ�.
	���� ���⿡ ���� û������ ���� ������ �����Ѵٸ�, �� �������� ȸ���� ���� �� ĭ�� �����ϰ� 1������ �����Ѵ�.
	���� ���⿡ û���� ������ ���ٸ�, �� �������� ȸ���ϰ� 2������ ���ư���.
	�� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���� ��쿡��, �ٶ󺸴� ������ ������ ä�� �� ĭ ������ �ϰ� 2������ ���ư���.
	�� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���̸鼭, ���� ������ ���̶� ������ �� �� ���� ��쿡�� �۵��� �����.
	�κ� û�ұ�� �̹� û�ҵǾ��ִ� ĭ�� �� û������ ������, ���� ����� �� ����.
	
	�Է�
	ù° �ٿ� ���� ũ�� N�� ���� ũ�� M�� �־�����. (3 �� N, M �� 50)
	
	��° �ٿ� �κ� û�ұⰡ �ִ� ĭ�� ��ǥ (r, c)�� �ٶ󺸴� ���� d�� �־�����. d�� 0�� ��쿡�� ������, 1�� ��쿡�� ������, 2�� ��쿡�� ������, 3�� ��쿡�� ������ �ٶ󺸰� �ִ� ���̴�.
	
	��° �ٺ��� N���� �ٿ� ����� ���°� ���ʺ��� ���� �������, �� ���� ���ʺ��� ���� ������� �־�����. �� ĭ�� 0, ���� 1�� �־�����. ������ ù ��, ������ ��, ù ��, ������ ���� �ִ� ��� ĭ�� ���̴�.
	
	�κ� û�ұⰡ �ִ� ĭ�� ���´� �׻� �� ĭ�̴�.
	
	���
	�κ� û�ұⰡ û���ϴ� ĭ�� ������ ����Ѵ�.
	
	���� �Է� 1 
	3 3
	1 1 0
	1 1 1
	1 0 1
	1 1 1
	���� ��� 1 
	1
 */
public class B_14503 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		/* ���� �� �ʱ�ȭ �κ� */
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[51][51];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		
		// ����! 
		Queue<Pair> qu = new LinkedList<>();
		qu.offer(new Pair(r, c));
		
		while (!qu.isEmpty()) {
			Pair p = qu.poll();
			map[p.X][p.Y] = 2; //û�� = 2
			int clean = 0;
			int orl = dir; //���� dir ����. 
			for (int k = 0; k < 4; k++) {
				dir = ( dir + 3 ) % 4; //�ٶ󺸴� ������ ���� ���� 
				int xx = p.X + dx[dir];
				int yy = p.Y + dy[dir];
				if (xx < 0 || yy < 0 || xx >= n || yy >= m) continue;
				if (map[xx][yy] < 1 ) { //û�Ұ� �� �Ǿ�������
					qu.offer(new Pair(xx, yy));
					break;
				}
				clean++;
			}
			if (clean == 4) {
				int rev = (orl + 2) % 4; //���� ���� 
				int xx = p.X + dx[rev];
				int yy = p.Y + dy[rev];
				if (xx < 0 || yy < 0 || xx >= n || yy >= m) break;
				if (map[xx][yy] != 1) {
					qu.offer(new Pair(xx, yy));
				} else {
					break;
				}
			}
		}
		int cnt = 0; //û���ϴ� ĭ�� ���� 
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 2) cnt++;
			}
		}
		System.out.println(cnt);
		
		
	}
}
