package b_20_hash;

import java.io.*;
import java.util.*;
import java.util.Map.*;

public class B_7785 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		/* 선언 및 초기화 부분 */
		int n = Integer.parseInt(br.readLine());
		Map<String, String> hs = new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String name = st.nextToken();
			String state = st.nextToken();
			if (state.equals("enter")) {
				hs.put(name, "enter");
			} else {
				hs.remove(name);
			}
		}
		ArrayList<Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(hs.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
			@Override
			public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
				return o2.getKey().compareTo(o1.getKey());
			}
		});
		
		for (Entry<String, String> s : list) {
			System.out.println(s.getKey());
		}
		
		
			
	}
}
