package b_12_backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//실패 -> 시간초과 장난아님
public class B_9663_2 {
	static int n;
	static int cnt = 0;
	static int[] res;
	static boolean[] vis;
	static int[] dy= {-1,1};
	private static void func(int idx) {
		if (idx == n) {
//			System.out.println(Arrays.toString(res));
			if (isCheck())	{
				cnt++;
			}
			return;
		}		
		for (int i = 0; i < n; i++) {
			if (!vis[i]) {
				vis[i] = true;
				res[idx] = i;
				func(idx+1);
				vis[i] = false;
			}
				
		}
	} 
	private static boolean isCheck() {
		for (int i = 0; i < n; i++) { //res 배열의 0부터 검사
			for (int j = 1; j < n-i; j++) {	// i+j배열 즉, 다음 칸부터 차례대로 대각선에 있는지 검사. 
				int xx = i + j;				
				for (int k = 0; k < 2; k++) {					
					int yy = res[i] + dy[k] * j;
//					System.out.println("bfs --> " +p.X + " " + p.Y + " : " + xx4 + " " + yy);
					if (yy >= n || yy < 0 ) continue;					
					if (yy == res[i+j]) {
						return false;
					}		
				}
			}
		}
		return true;
	}
	public void work() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		res = new int[n];
		vis = new boolean[n*n];
		func(0);
		System.out.println(cnt);
		
		
	}
}
