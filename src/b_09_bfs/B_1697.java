package b_09_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 
 * 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 
 * 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 
 * 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

	수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 '
	구하는 프로그램을 작성하시오.
 * 
 */
public class B_1697 {
	static int N, K;
	static int[] visited = new int[100002];
	static Queue<Integer> qu;
	static class State {
		int x;
		int count;
		public State(int x, int count) {
			this.x = x;
			this.count = count;
		}
	}
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		//기본 세팅 변수 넣기.
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		//visited = new boolean[100001];
		
		Arrays.fill(visited, -1);
		visited[N] = 0;
		
		qu = new LinkedList<>();

		boolean isOk = false;
		int res = 0;
		qu.offer(N);
		while (visited[K] == -1) {
			int x = qu.poll();			
			for (int k = 0; k < 3; k++) {
				int xx = x;
				if (k == 0) xx -= 1;
				else if (k == 1) xx += 1;
				else if (k == 2) xx = 2*x;
				if (xx == K) {
					isOk = true;
					res = visited[x]+1;
					break;
				}
				//System.out.println(visited[x] + " " + x + ": " + xx);
				if (xx > 100000 || xx <= 0 || visited[xx] != -1) continue;
				
				
				visited[xx] = visited[x] + 1;
				qu.offer(xx);
				
			}
			if (isOk) {
				break;
			}
		}
		System.out.println(res);
		
	}
}
