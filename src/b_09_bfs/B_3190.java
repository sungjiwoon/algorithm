package b_09_bfs;

import java.io.*;
import java.util.*;

public class B_3190 {
	static int[] times = new int[10001];
	public void work() throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		boolean[][] apple = new boolean[n+1][n+1];
		int m = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int ii = Integer.parseInt(st.nextToken());
			int jj = Integer.parseInt(st.nextToken());	
			apple[ii][jj] = true;
		}
		
		//방향을 바꾸기 전까지는 계속 직진이다!!!!
		
		m = Integer.parseInt(br.readLine());
		int dir_d = 100; //0 -> j+1 1 -> i+1 2 -> j-1 3->i-1
		
		int before = 0; //현재.
		int second = 0;
		for (int i = 1; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			second = Integer.parseInt(st.nextToken());
			String d = st.nextToken();	
			int dir = 0;
			if (d.equals("D")) {
				dir = (dir_d++) % 4;
			} else {
				dir = (dir_d--) % 4;
			}
			
			times[second+1] = dir; //위치 바뀌는 시점. 
			for (int k = before+1; k <= second; k++) {
				times[k] = times[before];
			}
			before = second+1;
			
		}
		
		for (int i = 1; i < second; i++) {
			System.out.print(times[i] + " ");
		}
		System.out.println();
		
		Deque<Pair> de = new ArrayDeque<>();
		de.addFirst(new Pair(1,1)); //머리 삽입. 
		de.addLast(new Pair(1,1)); //꼬리 삽입. 
		int res = 0;
		int ii = 1, jj = 1;
		for (int t = 1; t < 10001; t++) {
			if (times[t] == 0) { //j+1
				
				if (jj+1==n || (de.peekLast().Y >= jj+1 && de.peekFirst().Y <= jj+1 )) {
					//벽에 부딪힘. 
					res = t+1;
					System.out.println("여기서 걸림 " + (ii) + " " + (jj+1));
					break;
				}
				
				if (apple[ii][jj+1]) {
					de.addFirst(new Pair(ii, jj++));
				} else {
					de.addFirst(new Pair(ii, jj++));
					de.pollLast(); //꼬리 짜르기. 
				}
			} else if (times[t] == 1) {
				
				if (ii+1==n || (de.peekLast().X >= ii+1 && de.peekFirst().X <= ii+1 )) {
					//벽에 부딪힘. or 몸에 부딪힘. 
					System.out.println("여기서 걸림 " + (ii+1) + " " + (jj));
					res = t;
					break;
				}

				
				if (apple[ii+1][jj]) {
					de.addFirst(new Pair(ii++, jj));
				} else {
					de.addFirst(new Pair(ii++, jj));
					de.pollLast(); //꼬리 짜르기. 
				}
				
				
			} else if (times[t] == 2) {
				
				if (jj-1==0 || (de.peekLast().Y >= jj-1 && de.peekFirst().Y <= jj-1 )) {
					//벽에 부딪힘. 
					System.out.println("여기서 걸림 " + (ii) + " " + (jj-1));
					res = t;
					break;
				}
				
				if (apple[ii][jj-1]) {
					de.addFirst(new Pair(ii, jj--));
				} else {
					de.addFirst(new Pair(ii, jj--));
					de.pollLast(); //꼬리 짜르기. 
				}
				
				
				
			} else if (times[t] == 3) {
				
				if (ii-1==0 || (de.peekLast().X >= ii-1 && de.peekFirst().X <= ii-1 )) {
					//벽에 부딪힘. 
					System.out.println("여기서 걸림 " + (ii-1) + " " + (jj));
					res = t;
					break;
				}
				
				if (apple[ii-1][jj]) {
					de.addFirst(new Pair(ii--, jj));
				} else {
					de.addFirst(new Pair(ii--, jj));
					de.pollLast(); //꼬리 짜르기. 
				}
				
			}
		}
		
		System.out.println(res);
			
		
		
		
	}
}
