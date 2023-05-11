package b_20_hash;

import java.io.*;
import java.util.*;
import java.util.Map.*;

public class B_1620 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Map<Integer, String> hs = new HashMap<>();
		Map<String, Integer> hs2 = new HashMap<>();
		for(int i = 1; i <= n; i++) {
			String s = br.readLine();
			hs.put(i, s);
			hs2.put(s, i);
		}

		for (int i = 0; i < m; i++) {
			String s = br.readLine();			
			if (s.charAt(0) >= 'A' && s.charAt(0) <= 'z') {
				System.out.println(hs2.get(s));
			} else {
				System.out.println(hs.get(Integer.parseInt(s)));
			}
			
		}
		
		
	}
}
