package b_23_graph;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
/*
 * ��� ã�� (�ǹ�1)
 * 
 * ����ġ ���� ���� �׷��� G�� �־����� ��, ��� ���� (i, j)�� ���ؼ�, 
 * i���� j�� ���� ��ΰ� �ִ��� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * �׷��� �̿��Ͽ� BFS�� Ǯ����. 
 * 
 */
public class B_11403 {
	
	public void work() throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//�ʱ�ȭ ����. 
		int n = Integer.parseInt(br.readLine());
		
		TreeMap<Integer, ArrayList<Integer>> tm = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				if (st.nextToken().equals("1")) {
					if (tm.get(i) != null) {
						ArrayList<Integer> list = tm.get(i);
						list.add(j);
						tm.put(i, list);
					} else {
						ArrayList<Integer> list = new ArrayList<>();
						list.add(j);
						tm.put(i, list);
					}					
				}
			}
		}
		
		int[][] graph = new int[n][n];	
		for (int p = 0; p < n; p++) {
			ArrayList<Integer> list = tm.get(p);
			if (list == null) continue;
			
			Queue<Integer> qu = new LinkedList<>();
			boolean[] vis = new boolean[n];
			boolean ok = true;
			while (ok) {				
				for (int l : list) {
					graph[p][l] = 1;
					/* �湮���� �ʴ� ������ queue�� �߰��Ѵ�. */
					if (!vis[l])
						qu.add(l);
					vis[l] = true;
					//System.out.println(p + " : " + l);
				}
				
				if (qu.isEmpty()) break;
				
				/* list�� null�̸� queue���� �ٸ� ������ ã�� �����ش�. */				
				list = tm.get(qu.poll());
				while (list == null) {
					if (qu.isEmpty()) {
						ok = false;
						break;
					}
					list = tm.get(qu.poll());
				}
			}
		}
		
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(graph[i][j] + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
		
		
	}
}
