package b_23_graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * ���̷��� ����
 
	�ð� ����	�޸� ����	����	����	���� ���	���� ����
	1 ��	128 MB	136483	66018	44171	46.289%
	����
	���� ���̷����� �� ���̷����� ��Ʈ��ũ�� ���� ���ĵȴ�. �� ��ǻ�Ͱ� �� ���̷����� �ɸ��� �� ��ǻ�Ϳ� ��Ʈ��ũ �󿡼� ����Ǿ� �ִ� 
	��� ��ǻ�ʹ� �� ���̷����� �ɸ��� �ȴ�.
	
	���� ��� 7���� ��ǻ�Ͱ� <�׸� 1>�� ���� ��Ʈ��ũ �󿡼� ����Ǿ� �ִٰ� ����. 
	1�� ��ǻ�Ͱ� �� ���̷����� �ɸ��� �� ���̷����� 2���� 5�� ��ǻ�͸� ���� 3���� 6�� ��ǻ�ͱ��� ���ĵǾ� 2, 3, 5, 6 �� ���� ��ǻ�ʹ� �� ���̷����� �ɸ��� �ȴ�. ������ 4���� 7�� ��ǻ�ʹ� 1�� ��ǻ�Ϳ� ��Ʈ��ũ�󿡼� ����Ǿ� ���� �ʱ� ������ ������ ���� �ʴ´�.
	
	��� �� 1�� ��ǻ�Ͱ� �� ���̷����� �ɷȴ�. ��ǻ���� ���� ��Ʈ��ũ �󿡼� ���� ����Ǿ� �ִ� ������ �־��� ��, 
	1�� ��ǻ�͸� ���� �� ���̷����� �ɸ��� �Ǵ� ��ǻ���� ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
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
		
		//dfs ���� ���� 
		dfs(1);
		System.out.println(res);
		
		
		
	}
}
