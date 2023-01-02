package b_09_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
/*
 * ��� 5
 * ť�� �ΰ��� ���� ���� Ǯ����. ���̵��� ������ ����. 
 * 	����
	���ϻ����� �������� �ʷϻ��� ���̸� ���� ������ ���Ѵ�. ����, ���ϻ����� ����� ���� �׸��� �ƴ� ����� ���� �׸����� �� �ٸ� �� �ִ�.
	
	ũ�Ⱑ N��N�� �׸����� �� ĭ�� R(����), G(�ʷ�), B(�Ķ�) �� �ϳ��� ��ĥ�� �׸��� �ִ�. �׸��� �� ���� �������� �������� �ִµ�,
	������ ���� ������ �̷���� �ִ�. ��, ���� ������ �����¿�� ������ �ִ� ��쿡 �� ���ڴ� ���� ������ ���Ѵ�. (������ ���̸� ���� ������ ���ϴ� ��쵵 ���� �����̶� �Ѵ�)
	
	���� ���, �׸��� �Ʒ��� ���� ��쿡
	
	RRRBB
	GGBBB
	BBBRR
	BBRRR
	RRRRR
	���ϻ����� �ƴ� ����� ���� �� ������ ���� �� 4���̴�. (���� 2, �Ķ� 1, �ʷ� 1) ������, ���ϻ����� ����� ������ 3�� �� �� �ִ�. (����-�ʷ� 2, �Ķ� 1)
	
	�׸��� �Է����� �־����� ��, ���ϻ����� ����� ���� ���� �ƴ� ����� ���� �� ������ ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
	�Է�
	ù° �ٿ� N�� �־�����. (1 �� N �� 100)
	
	��° �ٺ��� N�� �ٿ��� �׸��� �־�����.
	
	���
	���ϻ����� �ƴ� ����� ���� ���� ������ ������ ���ϻ����� ����� ���� ���� ������ ���� �������� ������ ����Ѵ�.
 * 
 */
public class B_10026 {
	static int N;
	static char[][] borad;
	static char[][] borad2;
	static Queue<Color> qu1, qu2;
	class Color {
		int x,y;
		char c;
		public Color(int x, int y, char c) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		N = Integer.parseInt(br.readLine());
		borad = new char[N][N];
		borad2 = new char[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				borad[i][j] = s.charAt(j);
				borad2[i][j] = s.charAt(j);
				if (borad[i][j] == 'G') borad2[i][j] = 'R';
			}
		}
		
		qu1 = new LinkedList<>();
		qu2 = new LinkedList<>();
		boolean[][] visited1 = new boolean[N][N];
		boolean[][] visited2 = new boolean[N][N];
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int[] rgb = {0, 0, 0}; //red, green, blue
		
		int count1 = 0, count2 = 0;
	
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {				
				if (!visited1[i][j]) {
					qu1.offer(new Color(i, j, borad[i][j]));
					visited1[i][j] = true;
					while (!qu1.isEmpty()) {
						Color c = qu1.poll();
						for (int k = 0; k < 4; k++) {
							int xx = c.x+dx[k];
							int yy = c.y+dy[k];
							
							if (xx>=N || xx<0 || yy>=N || yy<0) continue;
							if (c.c == borad[xx][yy] && !visited1[xx][yy]) {							
								visited1[xx][yy]=true;
								qu1.offer(new Color(xx, yy, c.c));
							}
						}
					}
					count1++;
				}
				
				if (!visited2[i][j]) {
					qu2.offer(new Color(i, j, borad2[i][j]));
					visited2[i][j] = true;
					while (!qu2.isEmpty()) {
						Color c = qu2.poll();
						for (int k = 0; k < 4; k++) {
							int xx = c.x+dx[k];
							int yy = c.y+dy[k];
							
							if (xx>=N || xx<0 || yy>=N || yy<0) continue;
							
							if (c.c == borad2[xx][yy] && !visited2[xx][yy]) {							
								visited2[xx][yy]=true;
								qu2.offer(new Color(xx, yy, c.c));
							}
						}
					}
					count2++;
				}		
				
			}
		} //�ݺ��� ��
//		int sum = rgb[0]+rgb[1]+rgb[2];
		System.out.println(count1+ " " + count2);
		
		
	}
}
