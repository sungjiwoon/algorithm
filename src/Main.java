import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws Exception {		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/* 선언 및 초기화 부분 */		
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		int res = n;	
		boolean[] cnt = new boolean[100001];
		for (int i = 0; i < n; i++) {
			int j = i+1;
			while (j <= n && !cnt[a[j]]) {
				cnt[a[j]] = true;
			}
			res += j-i+1;
		}
		System.out.println(res);
		
		
	}
	
}
