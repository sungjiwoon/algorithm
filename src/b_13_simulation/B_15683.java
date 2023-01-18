package b_13_simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
//4�����̿�..?
//��..

/*
 * ����
��ŸƮ��ũ�� �繫���� 1��1ũ���� ���簢������ �������� �ִ� N��M ũ���� ���簢������ ��Ÿ�� �� �ִ�. �繫�ǿ��� �� K���� CCTV�� ��ġ�Ǿ��� �ִµ�, CCTV�� 5���� ������ �ִ�. �� CCTV�� ������ �� �ִ� ����� ������ ����.

				
1��	2��	3��	4��	5��
1�� CCTV�� �� �� ���⸸ ������ �� �ִ�. 2���� 3���� �� ������ ������ �� �ִµ�, 2���� �����ϴ� ������ ���� �ݴ�����̾�� �ϰ�, 3���� ���� �����̾�� �Ѵ�. 4���� �� ����, 5���� �� ������ ������ �� �ִ�.

CCTV�� ������ �� �ִ� ���⿡ �ִ� ĭ ��ü�� ������ �� �ִ�. �繫�ǿ��� ���� �ִµ�, CCTV�� ���� ����� �� ����. CCTV�� ������ �� ���� ������ �簢������ �Ѵ�.

CCTV�� ȸ����ų �� �ִµ�, ȸ���� �׻� 90�� �������� �ؾ� �ϸ�, �����Ϸ��� �ϴ� ������ ���� �Ǵ� ���� �����̾�� �Ѵ�.

0 0 0 0 0 0
0 0 0 0 0 0
0 0 1 0 6 0
0 0 0 0 0 0
�������� 0�� �� ĭ, 6�� ��, 1~5�� CCTV�� ��ȣ�̴�. ���� ���ÿ��� 1���� ���⿡ ���� ������ �� �ִ� ������ '#'�� ��Ÿ���� �Ʒ��� ����.

0 0 0 0 0 0
0 0 0 0 0 0
0 0 1 # 6 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
# # 1 0 6 0
0 0 0 0 0 0
0 0 # 0 0 0
0 0 # 0 0 0
0 0 1 0 6 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 1 0 6 0
0 0 # 0 0 0
��	��	��	��
CCTV�� ���� ����� �� ���� ������, 1���� �� ������ �����ϰ� ���� ���� 6�� �����ʿ� �ִ� ĭ�� ������ �� ����.

0 0 0 0 0 0
0 2 0 0 0 0
0 0 0 0 6 0
0 6 0 0 2 0
0 0 0 0 0 0
0 0 0 0 0 5
���� ���ÿ��� ������ �� �ִ� ������ �˾ƺ��� �Ʒ��� ����.

0 0 0 0 0 #
# 2 # # # #
0 0 0 0 6 #
0 6 # # 2 #
0 0 0 0 0 #
# # # # # 5
0 0 0 0 0 #
# 2 # # # #
0 0 0 0 6 #
0 6 0 0 2 #
0 0 0 0 # #
# # # # # 5
0 # 0 0 0 #
0 2 0 0 0 #
0 # 0 0 6 #
0 6 # # 2 #
0 0 0 0 0 #
# # # # # 5
0 # 0 0 0 #
0 2 0 0 0 #
0 # 0 0 6 #
0 6 0 0 2 #
0 0 0 0 # #
# # # # # 5
���� ��� 2: ��, ������ �ϴ� 2: ��	���� ��� 2: ��, ������ �ϴ� 2: ��	���� ��� 2: ��, ������ �ϴ� 2: ��	���� ��� 2: ��, ������ �ϴ� 2: ��
CCTV�� CCTV�� ����� �� �ִ�. �Ʒ� ���ø� ����.

0 0 2 0 3
0 6 0 0 0
0 0 6 6 0
0 0 0 0 0
���� ���� ��쿡 2�� ������ �� 3�� ������ ��� ���� ��� ���ù޴� ������ ������ ����.

# # 2 # 3
0 6 # 0 #
0 0 6 6 #
0 0 0 0 #
�繫���� ũ��� ����, �׸��� CCTV�� ������ �־����� ��, CCTV�� ������ ������ ���ؼ�, �簢 ������ �ּ� ũ�⸦ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� �繫���� ���� ũ�� N�� ���� ũ�� M�� �־�����. (1 �� N, M �� 8)

��° �ٺ��� N���� �ٿ��� �繫�� �� ĭ�� ������ �־�����. 0�� �� ĭ, 6�� ��, 1~5�� CCTV�� ��Ÿ����, �������� ������ CCTV�� �����̴�. 

CCTV�� �ִ� ������ 8���� ���� �ʴ´�.

���
ù° �ٿ� �簢 ������ �ּ� ũ�⸦ ����Ѵ�.

���� �Է� 1 
4 6
0 0 0 0 0 0
0 0 0 0 0 0
0 0 1 0 6 0
0 0 0 0 0 0
���� ��� 1 
20
���� �Է� 2 
6 6
0 0 0 0 0 0
0 2 0 0 0 0
0 0 0 0 6 0
0 6 0 0 2 0
0 0 0 0 0 0
0 0 0 0 0 5
���� ��� 2 
15
 */
public class B_15683 {
	static int n, m;
	static int[][] map1 = new int[10][10], map2 = new int[10][10];
	static int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
	static ArrayList<Pair> cctv = new ArrayList<>();
	static int mn = Integer.MAX_VALUE;
	private static void upd(Pair p, int dir) {
		dir %= 4; 
		int x = p.X;
		int y = p.Y;
		while (true) {
			x += dx[dir];
			y += dy[dir];
			if (x < 0 || x >= n || y < 0 || y >= m || map2[x][y] == 6) return;
			if (map2[x][y] != 0) continue;
			map2[x][y] = 7;
		}
	}
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		/* ���� �� �ʱ�ȭ �κ� */
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
	
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map1[i][j] = Integer.parseInt(st.nextToken());
				if (map1[i][j] > 0 && map1[i][j] < 6) {
					cctv.add(new Pair(i,j));
				}
			}			
		}
		
		for (int tmp = 0; tmp < Math.pow(4, cctv.size()); tmp++) {
			for (int i = 0; i < n; i++) 
				for (int j = 0; j < m; j++)
					map2[i][j] = map1[i][j]; 
			
			int brute = tmp;
			for (int i = 0; i < cctv.size(); i++) {
				int dir = brute % 4;
				brute /= 4;
				//4���� ����. 4�� ������ ��� ����� ���� ���� �� ����. 
				
				Pair p_c = cctv.get(i);
				int x = p_c.X;
				int y = p_c.Y;
				
				int monitor = map1[x][y];				
				Pair p = new Pair(x,y);
				
				switch(monitor) {
				case 1 :
					upd(p,dir);
					break;
				case 2 :
					upd(p,dir);
					upd(p,dir+2);
					break;
				case 3 :
					upd(p,dir);
					upd(p,dir+1);
					break;
				case 4 :
					upd(p,dir);
					upd(p,dir+1);
					upd(p,dir+2);
					break;
				case 5 :
					upd(p,dir);
					upd(p,dir+1);
					upd(p,dir+2);
					upd(p,dir+3);
					break;
				}
			}
			int cnt = 0; //�簢���� ����
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map2[i][j] == 0) cnt++;
				}
			}
			mn = Math.min(cnt, mn);
			
			
		}
		System.out.println(mn);
		
	}
}
