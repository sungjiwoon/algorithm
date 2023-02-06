import java.io.*;
import java.util.*;

public class Main {
	//이해못함 걍 포기~
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		/* 선언 및 초기화 부분 */
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		int[] b = new int[n];
		
		for (int i = 0; i < 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				if (i == 0)
					a[j] = Integer.parseInt(st.nextToken()); 
				else 
					b[j] = Integer.parseInt(st.nextToken());
			}
		}
		Arrays.sort(a);
		Arrays.sort(b);
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans += a[i] * b[n-i-1];
		}
		System.out.println(ans);
	}
	
}
