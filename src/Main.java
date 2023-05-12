import java.io.*;
import java.util.*;
import java.util.Map.Entry;


public class Main {

	public static void main(String[] args) throws Exception {		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		TreeSet<Integer> ts = new TreeSet<>();
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			int k = Integer.parseInt(st.nextToken());
			if (k == 1) {
				ts.add(i);
			}
		}
		
		int x = 0; //현재 위치. 
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int k = Integer.parseInt(st.nextToken());
			if (k == 1) {
				int place = Integer.parseInt(st.nextToken());
				
				if (ts.contains(place-1)) {
					ts.remove(place-1);
				} else {
					ts.add(place-1);
				}
				
			} else if (k == 2) {	
				x += Integer.parseInt(st.nextToken());
				if (x >= n) x %= n;
				
			} else if (k == 3) {
				if (ts.isEmpty()) sb.append("-1\n");
				else {
					int res = ts.first();
					if (ts.higher(x) != null) res = ts.higher(x);
					int v = Math.abs(res - x);
					sb.append(v+"\n");
				}
				
			}

		}
		System.out.println(sb);
	}
	
}
