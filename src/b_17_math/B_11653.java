package b_17_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * ���� : ���μ� ���� 
 * ���̵� : ����� 5
 * 
 */
public class B_11653 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		/* ���� �� �ʱ�ȭ �κ� */
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 2; i <= n; i++) {
			while (n % i == 0) {
				n /= i;
				sb.append(i+"\n");
			}
			if (n == 1) break;
		}
		System.out.println(sb);
	}
}
