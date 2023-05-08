package b_19_twopointer;
import java.io.*;
import java.util.*;

/*
 * 연속되는 소수의 합 (골3)
 * https://www.acmicpc.net/problem/1644
 */
public class B_1644 {
	private boolean is_prime(int n) {
		if (n==2 || n==3) return true;
		for (int i = 2; i <= Math.sqrt(n)+1; i++) 
			if (n % i == 0) return false;
		return true;
	}
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/* 선언 및 초기화 부분 */	
		int n = Integer.parseInt(br.readLine());
		
		//소수를 담는 배열을 만들었다!.
//		boolean[] arr = new boolean[n+1];
		int[] arr = new int[n+1];
		int j = 0;
		for (int i = 2; i <= n; i++) {
			if (is_prime(i)) arr[j++] = i;
		}
		
		int en = 0;
		int tot = arr[en];
		int res = 0; //경우의 수 담는 변수.
		for (int st = 0; st <= n; st++) {
			
			while (en <= n && tot < n) {
				en++;
				if (en <= n) {
					tot += arr[en];
				}
			}
			if (tot == n) res++;
			tot -= arr[st];
			
		}
		
		System.out.println(res);
		
			
	}
}
