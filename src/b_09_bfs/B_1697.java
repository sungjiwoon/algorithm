package b_09_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * �����̴� ������ ���ٲ����� �ϰ� �ִ�. �����̴� ���� �� N(0 �� N �� 100,000)�� �ְ�, 
 * ������ �� K(0 �� K �� 100,000)�� �ִ�. �����̴� �Ȱų� �����̵��� �� �� �ִ�. 
 * ����, �������� ��ġ�� X�� �� �ȴ´ٸ� 1�� �Ŀ� X-1 �Ǵ� X+1�� �̵��ϰ� �ȴ�. 
 * �����̵��� �ϴ� ��쿡�� 1�� �Ŀ� 2*X�� ��ġ�� �̵��ϰ� �ȴ�.

	�����̿� ������ ��ġ�� �־����� ��, �����̰� ������ ã�� �� �ִ� ���� ���� �ð��� �� �� ������ '
	���ϴ� ���α׷��� �ۼ��Ͻÿ�.
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
		
		//�⺻ ���� ���� �ֱ�.
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
