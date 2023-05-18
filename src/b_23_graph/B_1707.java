package b_23_graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;
/*
 * ������ ������ �������� -> 
 * ������ true �� ������ �� ������ �ع����� -> false
 * 
 * �̺� �׷��� .. �ϸ� ���� ���� �𸣰ھ.... ^^ ���� ^^
 */
public class B_1707 {
	static int n,m;
	static int[][] arr;
	static boolean[][] vis;
	static int res = 0;
	private static void dfs(int index, ArrayList<Integer> list, StringBuilder sb) {
		
		for (int i = 1; i <= n; i++) {
			if (!vis[index][i] && arr[index][i] == 1 && index != i) {
				vis[index][i] = vis[i][index] = true;
				list.add(i);
				sb.append(index + " : " + i + "\n");
				dfs(i, list, sb);
				
			}
		}
		
	}
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); //tc ��
		
		for (int t = 0; t < T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");			
			n = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			arr = new int[n+1][n+1];
			vis = new boolean[n+1][n+1];
			for (int e = 0; e < E; e++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a][b] = arr[b][a] = 1;
			}
			
			boolean is_bi = true;
			for (int i = 1; i <= n; i++) {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(i);
				dfs(i, list, sb);
				
				//list�� ���� Ȯ�� �ϱ�
				TreeSet<Integer> ts = new TreeSet<>();
				for (int l : list) {
					ts.add(l);
				}
				
				if (ts.size() != list.size()) {
					is_bi = false;
					break;
				}
			}
				
			if (is_bi) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
			
		}	
		System.out.println(sb);
		
		
	}
}
