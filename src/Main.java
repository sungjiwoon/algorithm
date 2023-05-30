import java.io.*;
import java.util.*;
import java.util.Map.Entry;


public class Main {

	public static void main(String[] args) throws Exception {		
	
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
