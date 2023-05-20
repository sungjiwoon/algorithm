package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 부분 순열의 합 
 * 완전탐색 
 * 해결 완료. 
 */
public class S_2817 {
	static int res = 0;
	private static void dfs (int k, int[] arr, boolean[] vis, int sum, int st, int n) {
		if (k == sum) {
			res++;
			//System.out.println("정담 : ");
//			for (int i = 0; i < n; i++) {
//				if (vis[i]) {
//					System.out.print(i + " ");
//				}
//			}
//			System.out.println();
			return;
		} else if (k < sum) {
			return;
		}
		
		for (int i = st+1; i < n; i++) {
			if (!vis[i]) {
				vis[i] = true;
				sum += arr[i];
				dfs(k,arr,vis,sum,i,n);
				vis[i] = false;
				sum -= arr[i];
			}
		}
	}
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			res = 0;
			boolean[] vis = new boolean[n];
			dfs(k, arr, vis, 0, -1, n);
//			int start = 0;
//			int end = start;
//			int sum = 0;
//			int res = 0;
//			while (start <= end && end < n) {
//				sum = arr[start];
//				while (sum < k && end < n) {
//					end++;
//					if (end < n) sum += arr[end];
//					
//					System.out.println("end : " + end);
//				}
//				if (sum == k) {
//					System.out.println("start : " + start + " end : " + end);
//					res++;
//				}
//				
//				start++;
//				end = start;
//				
//			}
			sb.append("#").append(t).append(" " + res).append("\n");
		}
		System.out.println(sb);
	}
}
