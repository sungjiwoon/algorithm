package b_09_bfs;

import java.io.*;
import java.util.*;
/*
 * 불켜기 (골드 2)
 * 약속 응용버전 ~!!! 
 * 예비 큐를 만드는 연습을 해야겠다.
 */
public class B_11967 {
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Queue<Pair>[] light = new LinkedList[n*n+1];
		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= n; j++) {
				light[n*i+j] = new LinkedList<>();
			}
		}
		
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			light[(x-1)*n+y].add(new Pair(a,b));
		}
		
		int[][] map = new int[n+1][n+1];
		Queue<Pair> qu = new LinkedList<>();
		qu.add(new Pair(1,1));
		
		int[] dx = {0,-1,0,1,0};
		int[] dy = {0,0,1,0,-1};
		boolean[][] vis = new boolean[n+1][n+1];
		
		HashMap<Integer, Integer> tmp = new HashMap<>(); //방문 못할 것 같은 곳 +1
		for (int i = 1; i<= n; i++) {
			for (int j = 1; j <= n; j++) {
				tmp.put((i-1)*n+j, 0);
			}
		}
		
		while (!qu.isEmpty()) {
			Pair p = qu.poll();
			map[p.X][p.Y] = 1;
			
			for (int k = 0; k < 5; k++) {
				int xx = p.X + dx[k];
				int yy = p.Y + dy[k];
				if (xx <= 0 || xx > n || yy <= 0 || yy > n) continue;
				if (vis[xx][yy]) continue;
				
				if (map[xx][yy] == 0) {
					//Pair tmp_p = new Pair(xx,yy);
					tmp.put((xx-1)*n+yy, tmp.get((xx-1)+yy)+1);
					continue;
				}
				
				while (!light[(xx-1)*n+yy].isEmpty()) {
					Pair l = light[(xx-1)*n+yy].poll();
					map[l.X][l.Y] = 1;
					
					if (tmp.get((l.X-1)*n+l.Y) > 0) {
						//System.out.println("다시 방문 : " + l.X + " " + l.Y);
						qu.add(l);
					}
				}
				
				qu.add(new Pair(xx,yy));
				vis[xx][yy] = true;
				
			}
		}
		
		int res = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (map[i][j] == 1) {
					//System.out.println(i+" "+j);
					res++;
				}
			}
		}
		System.out.println(res);
	
	
	}
}
