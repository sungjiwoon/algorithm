package b_09_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * ���� �� : ���� ���ϱ�
 * ���̵� : �ǹ� 1
 * �ı� : BFS �̿��ε�,, ��ǥ�� �迭�� �ִ� �Ϳ��� �ָ� �Ծ���. 
 * ����
	������ ������ 1�� M��N(M,N��100)ũ���� �����̰� �ִ�. �� ������ ���� ���ݿ� ���߾� K���� ���簢���� �׸� ��, �̵� K���� ���簢���� ���θ� ������ ������ �κ��� �� ���� �и��� �������� ����������.
	���� ��� M=5, N=7 �� ������ ���� <�׸� 1>�� ���� ���簢�� 3���� �׷ȴٸ�, �� ������ ������ <�׸� 2>�� ���� 3���� �и��� �������� ���������� �ȴ�.
	
	<�׸� 2>�� ���� �и��� �� ������ ���̴� ���� 1, 7, 13�� �ȴ�.
	
	M, N�� K �׸��� K���� ���簢���� ��ǥ�� �־��� ��, K���� ���簢�� ���θ� ������ ������ �κ��� �� ���� �и��� �������� ������������, �׸��� �и��� �� ������ ���̰� �������� ���Ͽ� �̸� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
	�Է�
	ù° �ٿ� M�� N, �׸��� K�� ��ĭ�� ���̿� �ΰ� ���ʷ� �־�����. M, N, K�� ��� 100 ������ �ڿ����̴�. 
	��° �ٺ��� K���� �ٿ��� �� �ٿ� �ϳ��� ���簢���� ���� �Ʒ� �������� x, y��ǥ���� ������ �� �������� x, y��ǥ���� ��ĭ�� ���̿� �ΰ� ���ʷ� �־�����. 
	�������� ���� �Ʒ� �������� ��ǥ�� (0,0)�̰�, ������ �� �������� ��ǥ��(N,M)�̴�. �ԷµǴ� K���� ���簢������ ������ ��ü�� ä��� ���� ����.
	
	���
	ù° �ٿ� �и��Ǿ� ���������� ������ ������ ����Ѵ�. ��° �ٿ��� �� ������ ���̸� ������������ �����Ͽ� ��ĭ�� ���̿� �ΰ� ����Ѵ�.
	
	���� �Է� 1 
	5 7 3
	0 2 4 4
	1 1 2 5
	4 0 6 2
	
	���� ��� 1 
	3
	1 7 13
 */
public class B_2583 {
	private static int M, N, K;
	private static int[][] map;
	private static Queue<Pair> qu;
	private static boolean[][] visited;
	private static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N  = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		visited = new boolean[M][N];
		for (int[] m : map) {
			Arrays.fill(m, 1);
		}
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for (int i = y1; i < y2; i++) { //���� �迭�� �׸����� �Ȱ��� �ʿ�� ����. ���� �Ȱ���. 
				for (int j = x1; j < x2; j++) {
					//System.out.println("->" + k + " (" + i + "," +j+ ")");
					map[i][j] = 0;
				}
			}
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
		qu = new LinkedList<>();
		ArrayList<Integer> areas = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0 || visited[i][j]) continue;
				qu.offer(new Pair(i, j));
				int count = 0;
				while (!qu.isEmpty()) {
					Pair p = qu.poll();
					for (int k = 0; k < 4; k++) {
						int xx = p.X + dx[k];
						int yy = p.Y + dy[k];
						if (xx >= M || xx < 0 || yy >= N || yy < 0) continue;
						if (map[xx][yy] == 1 && !visited[xx][yy]) {
							qu.offer(new Pair(xx, yy));
							visited[xx][yy] = true;
							count++;
						}
					}
				}
				if (count == 0) count++;
				areas.add(count);
			}
			
		}
		Collections.sort(areas);
		System.out.println(areas.size());
		for (int a : areas) {
			System.out.print(a + " ");
		}
		
		
	}
}
