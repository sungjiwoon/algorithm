package b_13_simulation;

import java.io.*;
import java.util.*;

/*
 * ������ (���4) 2��/512MB
 * Ǯ�� : dfs + bfs ��� �̿�.
 * ���� ����� �ִ� �迭�� ������ ��� ���ؼ�, �ϳ��� ����. -> dfs
 * ���̷��� �۶߸��� ���� bfs 
 * 
 * ����
	��ü�� ġ������ ���̷����� �����ϴ� �����ҿ��� ���̷����� ����Ǿ���. ������ ���̷����� ���� ������ �ʾҰ�, ���̷����� Ȯ���� ���� ���ؼ� �����ҿ� ���� ������� �Ѵ�.
	
	�����Ҵ� ũ�Ⱑ N��M�� ���簢������ ��Ÿ�� �� ������, ���簢���� 1��1 ũ���� ���簢������ �������� �ִ�. �����Ҵ� �� ĭ, ������ �̷���� ������, ���� ĭ �ϳ��� ���� �����Ѵ�. 
	
	�Ϻ� ĭ�� ���̷����� �����ϸ�, �� ���̷����� �����¿�� ������ �� ĭ���� ��� �������� �� �ִ�. ���� ���� �� �ִ� ���� ������ 3���̸�, �� 3���� ������ �Ѵ�.
	
	���� ���, �Ʒ��� ���� �����Ұ� ���� ��츦 ���캸��.
	
	2 0 0 0 1 1 0
	0 0 1 0 1 2 0
	0 1 1 0 1 0 0
	0 1 0 0 0 0 0
	0 0 0 0 0 1 1
	0 1 0 0 0 0 0
	0 1 0 0 0 0 0
	�̶�, 0�� �� ĭ, 1�� ��, 2�� ���̷����� �ִ� ���̴�. �ƹ��� ���� ������ �ʴ´ٸ�, ���̷����� ��� �� ĭ���� �������� �� �ִ�.
	
	2�� 1��, 1�� 2��, 4�� 6���� ���� ����ٸ� ������ ����� �Ʒ��� �������� �ȴ�.
	
	2 1 0 0 1 1 0
	1 0 1 0 1 2 0
	0 1 1 0 1 0 0
	0 1 0 0 0 1 0
	0 0 0 0 0 1 1
	0 1 0 0 0 0 0
	0 1 0 0 0 0 0
	���̷����� ���� ���� ����� �Ʒ��� ��������.
	
	2 1 0 0 1 1 2
	1 0 1 0 1 2 2
	0 1 1 0 1 2 2
	0 1 0 0 0 1 2
	0 0 0 0 0 1 1
	0 1 0 0 0 0 0
	0 1 0 0 0 0 0
	���� 3�� ���� ��, ���̷����� ���� �� ���� ���� ���� �����̶�� �Ѵ�. ���� �������� ���� ������ ũ��� 27�̴�.
	
	�������� ������ �־����� �� ���� �� �ִ� ���� ���� ũ���� �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
	�Է�
	ù° �ٿ� ������ ���� ũ�� N�� ���� ũ�� M�� �־�����. (3 �� N, M �� 8)
	
	��° �ٺ��� N���� �ٿ� ������ ����� �־�����. 0�� �� ĭ, 1�� ��, 2�� ���̷����� �ִ� ��ġ�̴�. 2�� ������ 2���� ũ�ų� ����, 10���� �۰ų� ���� �ڿ����̴�.
	
	�� ĭ�� ������ 3�� �̻��̴�.
	
	���
	ù° �ٿ� ���� �� �ִ� ���� ������ �ִ� ũ�⸦ ����Ѵ�.
	
	���� �Է� 1 
	7 7
	2 0 0 0 1 1 0
	0 0 1 0 1 2 0
	0 1 1 0 1 0 0
	0 1 0 0 0 0 0
	0 0 0 0 0 1 1
	0 1 0 0 0 0 0
	0 1 0 0 0 0 0
	���� ��� 1 
	27
 * 
 */
public class B_14502 {
	static int n, m;
	static int[][] map;
	static int[] nums, arr;
	static boolean[] vis;
	static int best = Integer.MIN_VALUE;
	
	private static void dfs(int depth, int st) {
		if (depth == 3) { 
			for (int i = 0; i < 3; i++) {
				int k = arr[i];
				int ci = k/m;
				int cj = k%m;
				if (map[ci][cj] != 0) return;
			}
			
			//bfs ���� �Ͽ� max �� ã��. 
			best = Math.max(bfs(), best);
			return;
		}
		
		for (int i = st; i < n*m; i++) {
			if (!vis[i]) {
				vis[i] = true;
				arr[depth] = nums[i];
				dfs(depth+1,i);
				vis[i] = false;
			}
		}
	}
	private static int bfs() {
		int[][] map_copy = new int[n][m];
		Queue<Pair> qu = new LinkedList<>();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map_copy[i][j] = map[i][j];
				
				if (map_copy[i][j] == 2) qu.offer(new Pair(i,j));
			}
		}
		
		for (int i = 0; i < 3; i++) {
			int k = arr[i];
			int ci = k/m;
			int cj = k%m;
			map_copy[ci][cj] = 1;
		}
		
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		while (!qu.isEmpty()) {
			Pair p = qu.poll();
			for (int k = 0; k < 4; k++) {
				int xx = p.X+dx[k];
				int yy = p.Y+dy[k];
				if (xx < 0 || xx >= n || yy < 0 || yy >= m) continue;
				if (map_copy[xx][yy] == 1) continue;
				if (map_copy[xx][yy] == 0) {
					map_copy[xx][yy] = 2;
					qu.offer(new Pair(xx,yy));
				}
			}
		}
		
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map_copy[i][j] == 0) sum++;
			}
		}
		
		return sum;
		
		
	}
	public void work() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		nums = new int[n*m];
		for (int i = 0; i < n*m; i++) {
			nums[i] = i;
		}
		arr = new int[3];
		vis = new boolean[n*m];
		
		
		dfs(0,0);
		System.out.println(best);
		
	}
}
