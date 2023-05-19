package b_23_graph;

import java.io.*;
import java.util.*;
/*
 * 
 * ���� : ��ȥ�� (�ǹ� 2) 
 * 1�� 
 * ����̴� �ڽ��� ��ȥ�Ŀ� �б� ���� �� �ڽ��� ģ���� ģ���� ģ���� �ʴ��ϱ�� �ߴ�. 
 * ������� ����� ��� N���̰�, �� �л����� �й��� ��� 1���� N�����̴�. ������� �й��� 1�̴�.

����̴� ������� ģ�� ���踦 ��� ������ ����Ʈ�� ������ �ִ�. 
�� ����Ʈ�� �������� ��ȥ�Ŀ� �ʴ��� ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�׷��� Ǯ�� 
 */
public class B_5567 {
	static int n, cnt = 0;
	static int[][] graph;
	static int[] arr;
	
	private static void dfs(int depth, int index) {
		if (depth > 2) return;
		
		for (int i = 2; i <= n; i++) {
			if (graph[index][i] == 1) {
				System.out.println(index + " " + i + ", depth :" + depth);
				arr[i] = Math.min(depth, arr[i]);
				
				dfs(depth+1, i);

			}
		}
		
	}
	public void work() throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		graph = new int[n+1][n+1];
		for (int i = 1; i <= m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = graph[b][a] = 1;
		}
		arr = new int[n+1];
		Arrays.fill(arr, 501);
		dfs(1, 1);
		
		for (int i = 2; i <= n; i++) {
			if (arr[i] < 3) cnt++;
		}
		System.out.println(cnt);
		
	}
}
