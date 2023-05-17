package b_23_graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 바이러스 성공
 
	시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
	1 초	128 MB	136483	66018	44171	46.289%
	문제
	신종 바이러스인 웜 바이러스는 네트워크를 통해 전파된다. 한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 네트워크 상에서 연결되어 있는 
	모든 컴퓨터는 웜 바이러스에 걸리게 된다.
	
	예를 들어 7대의 컴퓨터가 <그림 1>과 같이 네트워크 상에서 연결되어 있다고 하자. 
	1번 컴퓨터가 웜 바이러스에 걸리면 웜 바이러스는 2번과 5번 컴퓨터를 거쳐 3번과 6번 컴퓨터까지 전파되어 2, 3, 5, 6 네 대의 컴퓨터는 웜 바이러스에 걸리게 된다. 하지만 4번과 7번 컴퓨터는 1번 컴퓨터와 네트워크상에서 연결되어 있지 않기 때문에 영향을 받지 않는다.
	
	어느 날 1번 컴퓨터가 웜 바이러스에 걸렸다. 컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때, 
	1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성하시오.
 */
public class B_2606 {
	static int n,m;
	static int[][] arr = new int[101][101];
	static boolean[] vis = new boolean[101];
	static int res = 0;
	private static void dfs(int index) {
		if (vis[index]) return;
		if (index != 1) res++;
		vis[index] = true;
		for (int i = 2; i <= n; i++) {
			if (!vis[i] && arr[index][i]==1) {
				dfs(i);
			}
		}
		
	}
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = arr[b][a] = 1;
		}
		
		//dfs 수행 먼저 
		dfs(1);
		System.out.println(res);
		
		
		
	}
}
