import java.io.*;
import java.util.*;

public class Main {
	//이해못함 걍 포기~
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		/* 선언 및 초기화 부분 */
		int n = Integer.parseInt(br.readLine());
		int[] t = new int[15+n];
		int[] prices = new int[15+n];
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			t[i] = Integer.parseInt(st.nextToken()); 
			prices[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[15+n]; //i당 최대 가격  
		int max = 0;
		
		for (int i = 1; i <= n+1; i++) {
			
			dp[i] = Math.max(dp[i], max);
			dp[t[i] + i] = Math.max(dp[t[i]+i], prices[i]+dp[i]);
			max = Math.max(max,  dp[i]);
			
				
		}
		System.out.println(max);
	}
	
}
