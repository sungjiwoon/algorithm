import java.io.*;
import java.util.*;

public class Main {
	//���ظ��� �� ����~
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		/* ���� �� �ʱ�ȭ �κ� */
		int n = Integer.parseInt(br.readLine());
		long[] dp = new long[n+1];
		long[] values = new long[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			values[i] = Integer.parseInt(st.nextToken()); 
		}
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			
			long v = values[i];
			dp[i] = 1;
			for (int j = 1; j < i; j++) {
				if (v > values[j]) {
					dp[i] = Math.max(dp[j]+1, dp[i]);
				}
			}
				
		}
		long max = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			if (dp[i] > max) max = dp[i];
		}
		System.out.println(max);
	}
	
}
