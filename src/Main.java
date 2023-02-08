import java.io.*;
import java.util.*;


public class Main {
	//���ظ��� �� ����~
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		/* ���� �� �ʱ�ȭ �κ� */
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {			
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int[] dp = new int[n+1];
		dp[1] = arr[1];
		int sum = dp[1];
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i-1] + arr[i];
			sum += dp[i];
		}
		System.out.println(sum);
	
		
	}
	
}
