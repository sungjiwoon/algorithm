import java.io.*;
import java.util.*;

public class Main {
	//���ظ��� �� ����~
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		/* ���� �� �ʱ�ȭ �κ� */
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		int[] b = new int[n];
		
		for (int i = 0; i < 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				if (i == 0)
					a[j] = Integer.parseInt(st.nextToken()); 
				else 
					b[j] = Integer.parseInt(st.nextToken());
			}
		}
		Arrays.sort(a);
		Arrays.sort(b);
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans += a[i] * b[n-i-1];
		}
		System.out.println(ans);
	}
	
}
