import java.io.*;
import java.util.*;
import java.util.Map.Entry;


public class Main {

	public static void main(String[] args) throws Exception {		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[n+1];
		
		//최소 항은 가장 가까운 제곱수의 항의 수부터 뺴주면 된다!
		// 11 -> dp[9] + dp[2] 9는 가장 가까운 제곱수 이므로!! 
		
		dp[1] = 1;
		int rt = 1;
		for (int i = 2; i <= n; i++) {
			
			if ((int)Math.sqrt(i) * (int)Math.sqrt(i) == i) {
				dp[i] = 1;
				rt = i;
			} else {
				dp[i] = dp[rt] + dp[i-rt];
			}	
		}
		
		System.out.println(dp[n]);	
	}
	
}
