package b_09_bfs;

import java.io.*;
import java.util.*;

//지뢰찾기 문제!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 
public class SW_1868 {
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};
	static int n, res;
	static char[][] map;
	static int[][] mCnt;
	private static void click(int r, int c) {
		Queue<Pair> qu = new LinkedList<>();
		qu.add(new Pair(r,c));
		mCnt[r][c] = -1;
		while (!qu.isEmpty()) {
			Pair p = qu.poll();
			for (int k = 0; k < 8; k++) {
				int xx = p.X+dx[k];
				int yy = p.Y+dy[k];
				if (xx<0 || xx>=n || yy<0 || yy>=n) continue;
				if (mCnt[xx][yy] == 0) qu.add(new Pair(xx,yy));
				if (mCnt[xx][yy] >= 0) mCnt[xx][yy] = -1; //방문 표시.
			}
		}
//		System.out.println("---------");
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j< n; j++) {
//				System.out.print(mCnt[i][j]+" ");
//			}
//			System.out.println(" ");
//		}
//		System.out.println("---------");
		
	}
	private static void cnt_map() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == '.') {
					int cnt = 0;
					for (int k = 0; k < 8; k++) {
						int xx = i+dx[k];
						int yy = j+dy[k];
						if (xx<0 || xx>=n || yy<0 || yy>=n) continue;
						if (map[xx][yy] == '*') cnt++;
					}
					mCnt[i][j] = cnt;
				} else {
					mCnt[i][j] = -2; //지뢰 있는 곳은 -2로 표현. 
				}
			}	
		}
	}
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			
			n = Integer.parseInt(br.readLine());
			map = new char[n][n];
			mCnt = new int[n][n];
			res = 0;
			//배열 담기
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			
			// 계산 시작 
			
			cnt_map();			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j< n; j++) {
					if (mCnt[i][j] == 0) {
						click(i,j);
						res++;
					}
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j< n; j++) {
					if (mCnt[i][j] > 0) {
						res++;
					}
				}
			}		
			
			System.out.println("#"+ t +" "+res);
			

		}
		
	}
}





