package b_13_simulation;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

/*
 * 나무 재태크 
 * 난이도 : 골3
 * 시간초과 !! -> 해결 과정이 참 어려웠다. 
 */
public class B_16235 {
	static int N,M,K;
	static int[][] new_A, A; 
	static int[][] cnt_v;
	static PriorityQueue[][] trees; 
	/*
	 * 1) 봄 
	 * 자신의 나이만큼 양분을 먹고, 나이 +1
	 *  -> 여러 나무가 하나의 칸에 있다면, 가장 어린나무부터 양분을 먹음. 
	 *  양분이 부족해, 자신의 나이만큼 양분을 못 먹으면 죽음. 나이 : 0
	 * 
	 * 2) 여름
	 * 봄에 죽은 나무가 양분으로 변함. 죽은 나무의나이 /2 -> 양분 추가. (소수점 아래 버림)
	 * 
	 * 3) 가을 
	 * 나무 번식 (단, 나무 % 5 == 0) 때만, 인접한 8개의 칸에 나이 1인 나무가 생김. 
	 * 
	 * 4) 겨울 
	 * 땅에 양분을 추가
	 */
	
	private static int spring_summer(int i, int j) {
		int cnt = 0;
		PriorityQueue<Integer> qu = trees[i][j];
		PriorityQueue<Integer> new_q = new PriorityQueue<>();
		if (qu.isEmpty()) return 0;
	
		while (!qu.isEmpty()) {	
			/* 여름 과정 */
			if (A[i][j] < qu.peek()) { //나무 죽이는 과정. //여름 과정. 
				while(!qu.isEmpty()) {
					A[i][j] += qu.poll()/2;
				}
				break;
			}
			int age = qu.poll();
			A[i][j] -= age;
			if ((age+1) % 5 == 0) {
				cnt++;
			}
			new_q.add(age+1); //자신의 나이만큼 나무의 나이는 1 //새로운 나무를 넣음!.
			
		}
		
		trees[i][j] = new_q;
		return cnt;
	}
	
	private static void fall(int i, int j, int cnt) {
		int[] dx = {-1,-1,-1,0,0,1,1,1}, dy = {-1,0,1,-1,1,-1,0,1};
		for (int k = 0; k < 8; k++) {
			int xx = i+dx[k];
			int yy = j+dy[k];
			if (xx <= 0 || yy <= 0 || xx > N || yy > N) continue;
			PriorityQueue<Integer> tmp = trees[xx][yy];
			for (int kk = 0; kk < cnt; kk++) {
//				System.out.println("새로운 나무! :" + xx+" " + yy + " "+1);
				tmp.add(1);
			}
			trees[xx][yy] = tmp;
		}
	}	
	
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); //년도
		new_A = new int[N+1][N+1];
		A = new int[N+1][N+1]; //양분. 
		trees = new PriorityQueue[N+1][N+1]; //나무의 나이
		cnt_v = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				PriorityQueue<Integer> qu = new PriorityQueue<>();
				trees[i][j] = qu;
				A[i][j] = 5;
			}
		}
		
		// 맨 처음 양분의 값. : 5. 
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				new_A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			PriorityQueue<Integer> qu = trees[x][y];
			qu.add(age);
			trees[x][y] = qu;
			
		}
		
		while (K-- > 0) {
			//봄 & 여름 
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					cnt_v[i][j]= spring_summer(i, j);
				}
			}
			
			//가을 & 겨울 . 
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					A[i][j] += new_A[i][j]; //겨울 
					if (cnt_v[i][j] == 0) continue;
					fall(i,j,cnt_v[i][j]);
					cnt_v[i][j] = 0;
				}
			}			
		}
		
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				ans += trees[i][j].size();
			}
		}
		System.out.println(ans);
		
		
	}
}









