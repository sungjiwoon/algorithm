package b_25_topology_sort;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

/*
 * 위상정렬 : 큐를 이용한 위상 정렬 이용. 
 * indegree 가 0인 경우, qu에 넣는 방식으로 진행 !!!!!!! 
 * 난이도 : 골3
 */
public class B_2252 {
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n+1];
		Queue<Integer> qu = new LinkedList<>();
		HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
		
		for (int i = 1; i <= n; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			hm.put(i, list);
		}
		
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			ArrayList<Integer> list = hm.get(x);
			list.add(y);
			hm.put(x, list);
			
			arr[y]++;
		}
		
		for (int i = 1; i <= n; i++) {
			if (arr[i] == 0) {
				qu.add(i);
			}
		}
		
		while (!qu.isEmpty()) {
			int q = qu.poll();
			ArrayList<Integer> list = hm.get(q);
			for (int l : list) {
				arr[l]--;
				if (arr[l] == 0) qu.add(l);
			}
			sb.append(q + " ");
		}
		System.out.println(sb);
	}
}









