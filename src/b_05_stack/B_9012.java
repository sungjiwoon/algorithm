package b_05_stack;

import java.io.*;
import java.util.*;

public class B_9012 {
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			
			Stack<Character> st = new Stack<>();
			boolean ok = true;
			for (int j = 0; j < s.length(); j++) {
				char c = s.charAt(j);
				if (c == '(') {
					st.push('(');
				} else {
					if (st.isEmpty()) {
						ok = false;
						break;
					} else {
						st.pop();
					}
				}
			}
			if (!st.isEmpty()) ok = false;
			if (ok) System.out.println("YES");
			else System.out.println("NO");
			
		}
		
	}
}
