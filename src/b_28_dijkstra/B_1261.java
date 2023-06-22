package b_28_dijkstra;

import java.io.*;
import java.util.*;
/*
 * �˰��� (���4)
 * �켱����ť + bfs
 */
public class B_1261 {

	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		int[][] map = new int[n+1][m+1];
		
		PriorityQueue<int[]> qu = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[2] == o2[2]) {
					//0(i)�� ��ǥ�� n�� ��������, 1(j)�� ��ǥ�� m�� ����� ����. 					
					return ((m-o1[1]) + (n-o1[0])) - ((m-o2[1]) + (n-o2[0]));			
				}
				return o1[2] - o2[2]; // 0 : i��ǥ, 1: j��ǥ, 2 : ���ݱ����� �� �μ��� Ƚ�� 
				
			}
		}); 
		
		for (int i = 1; i <= n; i++) {
			String line = br.readLine();
			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j-1)));
			}
		}
		
		
		int[][] vis = new int[n+1][m+1]; //���� �μ��� Ƚ���� ���� �迭. 
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				vis[i][j] = 1002; //n �� m �� �ִ밡 100�̹Ƿ� 100*100 �̻��� ������ �ʱ�ȭ. 
			}
		}
		
		int[] start = {1,1,0};
		qu.add(start);
		
		int min = Integer.MAX_VALUE;
		while (!qu.isEmpty()) {
			
			int[] q = qu.poll();
			
			if (q[0] == n && q[1] == m) {
				min = Math.min(min, q[2]);
				continue;
			}
			
			for (int k = 0; k < 4; k++) {
				int xx = q[0] + dx[k];
				int yy = q[1] + dy[k];
				if (xx <= 0 || xx > n || yy <= 0 || yy > m) continue;
				
				if (q[2] + map[xx][yy] >= vis[xx][yy]) continue;
				
				int[] nxt = {xx,yy,q[2]+map[xx][yy]};
				vis[xx][yy] = q[2]+map[xx][yy];
				
				//System.out.println("�湮 : " + vis[xx][yy] + " (" + xx + ", " + yy+ ")");
				qu.add(nxt);
			}
			
		}
		System.out.println(min);
		
	}
}








