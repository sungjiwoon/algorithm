package b_17_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_6064 {
	private static int gcd(int m, int n) { //공약수 구하기
		if ( m == 0 ) return n;
		return gcd(n % m, m);
	}
	private static int lcm(int n, int m) {
		return n / gcd(n, m) * m;
	}
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		/* 선언 및 초기화 부분 */
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int m = Integer.parseInt(st.nextToken()); 
			int n = Integer.parseInt(st.nextToken()); 
			int x = Integer.parseInt(st.nextToken()); 
			int y = Integer.parseInt(st.nextToken()); 
			
			int res = -1;
			//최소 공배수 구하기.
			int l = lcm(m,n);
			for (int i = 1; i <= l; i++) {
				if (l < x || l < y) break;
				if (i % m == x && i % n == y) {
					res = i;
					break;
				}
			}
			sb.append(res+"\n");
		}
		System.out.println(sb);
		
	}
}
 
