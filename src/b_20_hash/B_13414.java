package b_20_hash;

import java.io.*;
import java.util.Map.*;
import java.util.*;

public class B_13414 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> hs = new HashMap<>(); //´ë±â¿­
		for (int i = 1; i <= m; i++) {
			String s = br.readLine();
			if (hs.get(s) != null ) {
				hs.remove(s);
				hs.put(s, i);
			} else {
				hs.put(s, i);
			}
		}
		ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(hs.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		
		int i = 0;
		for (Map.Entry<String, Integer> l : list) {
			System.out.println(l.getKey());
			i++;
			if (i == n) break;
		}
		
	}
}







