import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		/* ���� �� �ʱ�ȭ �κ� */
		int n = Integer.parseInt(br.readLine());
		
		long[] dp = new long[101];
		dp[1] = 9;
		dp[2] = 17;
		for (int i = 3; i <= n; i++) {
			dp[i] = ((dp[i-1]*2)-1)%1000000000;
			//i��°���� �� �� ū ��. 
			
		}
		System.out.println(dp[n]);
	}
	
}
