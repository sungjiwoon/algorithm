import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		/* 선언 및 초기화 부분 */
		int n = Integer.parseInt(br.readLine());
		
		long[] dp = new long[101];
		dp[1] = 9;
		dp[2] = 17;
		for (int i = 3; i <= n; i++) {
			dp[i] = ((dp[i-1]*2)-1)%1000000000;
			//i번째에서 합 중 큰 값. 
			
		}
		System.out.println(dp[n]);
	}
	
}
