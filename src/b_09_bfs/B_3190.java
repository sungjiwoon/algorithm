package b_09_bfs;

import java.io.*;
import java.util.*;
/*
 * �� (��� 4)
 * deque �� ������ �� �־ ���Ҵ�. 
 * 
 */
public class B_3190 {
	public void work() throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		boolean[][] apple = new boolean[n+1][n+1];
		int k = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int ii = Integer.parseInt(st.nextToken());
			int jj = Integer.parseInt(st.nextToken());	
			apple[ii][jj] = true;
		}
		
		//������ �ٲٱ� �������� ��� �����̴�!!!!
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		//HashMap<Integer, Integer> times = new HashMap<>();
		Queue<int[]> times = new LinkedList<>();
		
		int l = Integer.parseInt(br.readLine());
		int dir = 100; //ù ������ ������. 

		while (l-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			String c = st.nextToken();
			
			if (c.equals("L")) dir--;
			else dir++;
			int[] time = {x, dir%4};
			times.add(time);
			
		}
		

		Deque<Pair> de = new LinkedList<>();
 		de.addFirst(new Pair(1,1)); //�Ӹ�
		boolean[][] vis = new boolean[n+1][n+1]; //���� ������ �ִ� ��ġ. 
		vis[1][1] = true; 
		
		/*
		 * ���� ���� 
		 * 1. �� Ȥ�� �ڱ��ڽŰ� �ε����� ���� ��. 
		 */

		
		boolean ok = true;
		int now = 1;
		int now_dir = 0;
		int res = 0;
		while (ok) {
			
			int next = 10001;
			int next_dir = 0;
			if (!times.isEmpty()) {
				int[] q = times.poll();
				next = q[0];
				next_dir = q[1];
			}
			
			for (int i = now; i <= next; i++) {
				Pair p = de.getFirst();
				int xx = p.X + dx[now_dir];
				int yy = p.Y + dy[now_dir];
				//System.out.println(i + "�� : " + now_dir + "(" + xx + "," + yy+")");
				if (xx <= 0 || xx > n || yy <= 0 || yy > n || vis[xx][yy]) {
					
					ok = false;
					res = i;
					break;
				}
				
				if (apple[xx][yy]) {
					apple[xx][yy] = false;	
				} else {
					Pair tail = de.pollLast(); //���� ����. 
					//System.out.println("�������� (" + tail.X + "," + tail.Y+")");
					vis[tail.X][tail.Y] = false;
				}
				
				de.addFirst(new Pair(xx,yy));
				vis[xx][yy] = true;
			}
			
			now = next+1;
			now_dir = next_dir;
			
		}
		
		System.out.println(res);

	}
}
