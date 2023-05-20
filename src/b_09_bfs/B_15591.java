package b_09_bfs;

import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/15591

/* 최소신장 트리를 가지고 푸는 문제이다. 이해를 못해서 다음에 풀어보는 시간을 갖도혹 했다. */
public class B_15591 {
	static int[][] usado;
	static int n;
	private static void dfs(int bb, int aa) {
		
		
	
		
	}
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		TreeMap<Integer, ArrayList<Integer>> tm = new TreeMap<>();
		
		usado = new int[n+1][n+1];
		//usodo 입력. 
		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int pi = Integer.parseInt(st.nextToken());
			int qi = Integer.parseInt(st.nextToken());
			int ri = Integer.parseInt(st.nextToken());
			
			usado[pi][qi] = usado[qi][pi] = ri;
			
			if (tm.get(pi) == null) {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(qi);
				tm.put(pi, list);
			} else {
				ArrayList<Integer> list = tm.get(pi);
				list.add(qi);
				tm.put(pi, list);
			}
			
			if (tm.get(qi) == null) {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(pi);
				tm.put(qi, list);
			} else {
				ArrayList<Integer> list = tm.get(qi);
				list.add(pi);
				tm.put(qi, list);
			}
		}
		
		// Map에 저장된 정보들을 하나씩 꺼내서, 확인한다!!!!
		// 최소 이중으로 계산해야함.. ㅎ
		
		Queue<Integer> qu1 = new LinkedList<>();
		Queue<Integer> qu2 = new LinkedList<>();
		int start = 1;
		qu1.add(start);
		
		while (start < n) {
			
			int q1 = qu1.poll();
			ArrayList<Integer> list = tm.get(q1);
			if (list == null) qu1.add(start+1);
			else {
				for (int l : list) { // usado[q1][l] -> 값이 있다는 뜻 
					if (l != q1)
						qu2.add(l);					
				}
				
				while (!qu2.isEmpty()) {
					int q2 = qu2.poll();
					ArrayList<Integer> list2 = tm.get(q2); //-> usado[q2][l], usado[q1][q2] 값이 있음. 
					for (int l : list2) {
						if (l == q1 || l == q2) continue;
						if (usado[q1][l] == 0) 
							usado[q1][l] = usado[l][q1] = Math.min(usado[q1][q2], usado[q2][l]);
						
					}
				}
			}
			
			start++;
			qu1.add(start);
			
		}
		
//		for (int aa = 1; aa <= n; aa++) {
//			for (int bb = 1; bb <= n; bb++) {
//				for (int cc = 1; cc <= n; cc++) {
//					if (aa == bb || bb == cc || aa == cc) continue;					
//					if (usado[aa][bb] != 0 && usado[bb][cc] != 0 && usado[aa][cc] == 0) {
//						usado[aa][cc] = usado[cc][aa] = Math.min(usado[aa][bb], usado[bb][cc]);
//					} else if (usado[aa][bb] != 0 && usado[bb][cc] == 0 && usado[aa][cc] != 0) {
//						usado[bb][cc] = usado[cc][bb] =Math.min(usado[aa][bb], usado[aa][cc]);
//					} else if (usado[aa][bb] == 0 && usado[bb][cc] != 0 && usado[aa][cc] != 0) {
//						usado[aa][bb] = usado[bb][aa] = Math.min(usado[bb][cc], usado[aa][cc]);
//					}
//				}
//			}
//		}
		
		System.out.println(Arrays.deepToString(usado));
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int ki = Integer.parseInt(st.nextToken());
			int index =  Integer.parseInt(st.nextToken());
			int cnt = 0;
			for (int k = 1; k <= n; k++) {
				if (usado[index][k] >= ki) cnt++;
			}
			sb.append(cnt+"\n");
		}
		System.out.println(sb);
		
	}
}
