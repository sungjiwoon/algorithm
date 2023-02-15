import java.io.*;
import java.util.*;


public class Main {
	//이해못함 걍 포기~
	static long[] a;

	private static int binary_search(int start, int end, long k) {
		while (start <= end) {
			int mid = (start + end) / 2;
			if (a[mid] < k) {
				start = mid+1;
			} else if (a[mid] > k) {
				end = mid-1;
			} else 
				return 1;
		} 
		return 0;
			
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		/* 선언 및 초기화 부분 */	
		
		int n = Integer.parseInt(br.readLine());
		a = new long[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) a[i] = Long.parseLong(st.nextToken());
		Arrays.sort(a);
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < m; i++) {
			long k = Integer.parseInt(st.nextToken());
			
			System.out.println(binary_search(0, n, k));
		}
		
	}
	
}
