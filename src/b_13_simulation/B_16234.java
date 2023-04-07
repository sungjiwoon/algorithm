package b_13_simulation;

import java.io.*;
import java.util.*;

public class B_16234 {
	static int n, l, r;
	static int[][] nums;
	static ArrayList<Pair> list;
	static int res = 0;
	static boolean[][] vis;
	
	private static void changePopulation() {
		
		while (true) {
			boolean isOk = false;
			vis = new boolean[n][n];			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!vis[i][j]) {
						bfs(i, j);
						if (list.size() > 1) {
						//¿Œ±∏ºˆ πŸ≤„¡‹.
							int sum = 0;
							for (Pair p : list) {
								sum += nums[p.X][p.Y];
							}
							int av = sum / list.size();
							for (Pair p : list) {
								nums[p.X][p.Y] = av;
								
							}		
							isOk = true;
						} 
					}
				}
			}
	
			if (!isOk) return;
			res++;			
		}

	}
	private static void bfs(int i, int j) {
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		list = new ArrayList<>();
		Queue<Pair> qu = new LinkedList<>();
		qu.add(new Pair(i,j));
		list.add(new Pair(i,j));
		vis[i][j] = true;
		
		while (!qu.isEmpty()) {
			Pair p = qu.poll();
			for (int k = 0; k < 4; k++) {
				int xx = p.X+dx[k];
				int yy = p.Y+dy[k];
				if (xx < 0 || xx >= n || yy < 0 || yy >= n) continue;
				if (!vis[xx][yy]) {
					int minus = Math.abs(nums[p.X][p.Y] - nums[xx][yy]);
					if (minus <= r && minus >= l) {
						list.add(new Pair(xx,yy));
						qu.add(new Pair(xx,yy));
						vis[xx][yy] = true;
						
					}
				}
			}
		}
	}
	
	public static void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		l = Integer.parseInt(s[1]);
		r = Integer.parseInt(s[2]);
		
		nums = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				nums[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		changePopulation();
		System.out.println(res);
		
	}
}
