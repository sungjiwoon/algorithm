import java.io.*;
import java.util.*;


public class Main {
	//이해못함 걍 포기~
	static long[] a;
	private static int upper(int st, int en, long k) {
		while (st < en) { //같아지는 순간에 return
			int mid = (st+en) / 2;
			if (a[mid] > k) en = mid;
			else st = mid+1;
		}
		return st;
	}
	
	private static int lower(int st, int en, long k) {
		while (st < en) { //같아지는 순간에 return
			int mid = (st+en) / 2;
			if (a[mid] >= k) en = mid;
			else st = mid+1;
		}
		return en;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		/* 선언 및 초기화 부분 */	
		
		int n = Integer.parseInt(br.readLine());
		a = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < n; i++) a[i] = Long.parseLong(st.nextToken());
		
		Arrays.sort(a);
		int m = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < m; i++) {
			long k = Long.parseLong(st.nextToken());
			
			int start = upper(0, n, k);
			int end = lower(0, n, k);
			sb.append(Math.abs(end-start) + " ");
		}
		System.out.println(sb);
		
	}
	
}
