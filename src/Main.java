import java.io.*;
import java.util.*;
import java.util.Map.Entry;


public class Main {

	public static void main(String[] args) throws Exception {		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		TreeMap<Integer, TreeSet<Integer>> tmap = new TreeMap<>();
		TreeSet<Integer> solve = new TreeSet<>(); //문제 담는 곳. 
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			if (tmap.containsKey(l)) {
				TreeSet<Integer> ts = tmap.get(l);
				ts.add(p);
				tmap.put(l, ts);
			} else {
				TreeSet<Integer> ts = new TreeSet<>();
				ts.add(p);	
				tmap.put(l, ts);
			}
			solve.add(p);
		}
		
		int m = Integer.parseInt(br.readLine());
		for (int i = 0;i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String s = st.nextToken();
			if (s.equals("add")) {
				
				int p = Integer.parseInt(st.nextToken());
				int l = Integer.parseInt(st.nextToken());
				
				if (tmap.containsKey(l)) {
					TreeSet<Integer> ts = tmap.get(l);
					ts.add(p);
					tmap.put(l, ts);
				} else {
					TreeSet<Integer> ts = new TreeSet<>();
					ts.add(p);	
					tmap.put(l, ts);
				}
				solve.add(p);
				
			} else if (s.equals("recommend")) {
				int k = Integer.parseInt(st.nextToken());
				int p = 0;
				if (k == 1) {					
					while (p == 0) {
						int max = tmap.lastKey();
						TreeSet<Integer> ts = tmap.get(max);
						for (int t : ts) {
							if (solve.contains(t)) {
								p = t;
							}
						}
						if (p == 0) {
							tmap.remove(max);
						}
					}
					
				} else {
					
					while (p == 0) {
						int min = tmap.firstKey();
						TreeSet<Integer> ts = tmap.get(min);
						for (int t : ts) {
							if (solve.contains(t)) {
								p = t;
								break;
							}
						}
						if (p == 0) {
							tmap.remove(min);
						}
					}
				}
				sb.append(p+"\n");
				
			} else if (s.equals("solved")) {
				int p = Integer.parseInt(st.nextToken());
				solve.remove(p);				
			}

		}
		System.out.println(sb);
	}
	
}
