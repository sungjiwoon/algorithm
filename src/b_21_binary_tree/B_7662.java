package b_21_binary_tree;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
//Treemap 이용한 정렬 문제!!
public class B_7662 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			TreeMap<Integer, Integer> tmap = new TreeMap<>();
			int K = Integer.parseInt(br.readLine()); //입력 데이터의 수 . 
			for (int k = 0; k < K; k++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				String s = st.nextToken();
				int n = Integer.parseInt(st.nextToken());
				
				if (s.equals("I")) {
					if (tmap.containsKey(n)) {
						tmap.put(n, tmap.get(n)+1);
						
					} else {
						tmap.put(n, 0);
					}
				} else {
					if (tmap.isEmpty()) continue;
					else if (n == -1) {
						int min = tmap.firstKey();
						if (tmap.get(min) > 0) tmap.put(min, tmap.get(min)-1);
						else tmap.remove(min);
					} else {
						int max = tmap.lastKey();
						if (tmap.get(max) > 0) tmap.put(max, tmap.get(max)-1);
						else tmap.remove(max);
					}
				}
			}
			
			if (tmap.isEmpty()) {
				sb.append("EMPTY\n");
			} else {
				sb.append(tmap.lastKey()+" "+tmap.firstKey()+"\n");
			}
		}
		System.out.println(sb);
			
		
	}
}
