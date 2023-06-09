package b_27_floyd;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
/*
 * 문제명 : 플로이드 (골4)
 * 플로이드의 기초를 풀 수 있는 문제
 * 시간 복잡도가 O(V의 3승) 임. 
 * 
 * 테이블을 갱신할 때 중간에 거쳐가게끔 할 원소를 3중 for문의 제일 바깥에 두어야한다는건 꼭 기억하셔야 합니다.
 * 
 *  컴퓨터는 1초에 3-5억 번의 연산을 할 수 있다는 얘기를 했었습니다. 
 *  그 기준에 맞춰서 생각을 해보면 정점이 1000개일 때 플로이드 알고리즘은 O(n3)으로 계산할 때
 *  10억이라 플로이드 알고리즘을 쓸 수 없겠다 싶지만 코드에서 볼 수 있듯 
 *  플로이드 알고리즘은 단순 사칙연산이 주를 이루기 때문에 정점 1000개 정도까지는 플로이드 알고리즘으로 풀어볼만 합니다.
 */
public class B_11404 {
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		long[][] bus = new long[n+1][n+1];
		for (int i = 0; i <= n; i++) 
			for (int j = 0; j <= n; j++) 
				bus[i][j] = Integer.MAX_VALUE;
		
		while (m-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			bus[a][b] = Math.min(c, bus[a][b]);
			
			
		}
		
		for (int i = 1; i <= n; i++) bus[i][i] = 0;
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {	
					bus[i][j] = Math.min(bus[i][k]+bus[k][j], bus[i][j]);
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (bus[i][j] == Integer.MAX_VALUE) bus[i][j] = 0;
				System.out.print(bus[i][j] + " ");
			}
			System.out.println();
		}
	}
}
