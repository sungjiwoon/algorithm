package b_17_math;

import java.io.*;
import java.util.*;
/*
 * GCD �� �����ٱ��� ��4
 
�ð� ����	�޸� ����	����	����	���� ���	���� ����
1 ��	128 MB	30473	12205	9987	40.922%
����
���� ���� n���� �־����� ��, ������ ��� ���� GCD�� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� �׽�Ʈ ���̽��� ���� t (1 �� t �� 100)�� �־�����. �� �׽�Ʈ ���̽��� �� �ٷ� �̷���� �ִ�. �� �׽�Ʈ ���̽��� ���� ���� n (1 < n �� 100)�� �־�����, �������� n���� ���� �־�����. �Է����� �־����� ���� 1,000,000�� ���� �ʴ´�.

���
�� �׽�Ʈ ���̽����� ������ ��� ���� GCD�� ���� ����Ѵ�.

���� �Է� 1 
3
4 10 20 30 40
3 7 5 12
3 125 15 25
���� ��� 1 
70
3
35
 */
public class B_9613 {
	private static long gcd(long a, long b) { //�ִ����� ���ϴ� �Լ�. 
		if (b == 0) return a;
		return gcd(b, a%b);
	}
	
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		/* ���� �� �ʱ�ȭ �κ� */
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			long arr[] = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			long res = 0;
			for (int i = 0; i < n; i++) {
				for (int j = i+1; j < n; j++) {
					res += gcd(arr[i],arr[j]);
				}
			}
			System.out.println(res);
			
		}
	
		
	}
}
