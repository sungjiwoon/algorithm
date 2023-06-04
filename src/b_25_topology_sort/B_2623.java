package b_25_topology_sort;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;
/*
 * 위상정렬 기본 문제 
 * 골드 3
 * 사이클 있으면 방문이 안된다는 점 이용 ! 
 */
public class B_2623 {
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] state = new int[n+1]; 
		HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
		for (int i = 1; i <= n; i++) hm.put(i, new ArrayList<>());
		
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int singer = Integer.parseInt(st.nextToken());
			int be = 0, after = 0;
			while (singer-- > 0) {
				after = Integer.parseInt(st.nextToken());
				
				if (be > 0) {
					//첫번째 순서 이후부터!. 
					ArrayList<Integer> list = hm.get(be);
					list.add(after);
					hm.put(be, list);
			
					state[after]++;
				} 
				
				be = after;
			}
		}
		
		Queue<Integer> qu = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			if (state[i] == 0) {
				qu.add(i);
			}
		}
		
		boolean[] vis = new boolean[n+1];
		while (!qu.isEmpty()) {
			int q = qu.poll();
			ArrayList<Integer> list = hm.get(q);
			
			for (int l : list) {
				state[l]--;
				if (state[l] == 0) qu.add(l);
			}
			sb.append(q+"\n");
			vis[q] = true;
		}
		for (int i = 1; i <= n; i++) {
			if (!vis[i]) {
				System.out.println("0");
				return;
			}
		}
		System.out.println(sb);
		
	}
}





