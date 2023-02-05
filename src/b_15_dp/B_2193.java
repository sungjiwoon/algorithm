package b_15_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * ���� �� : ��ģ�� 
 * ���̵� : �ǹ� 3
 * ����
	0�� 1�θ� �̷���� ���� �������� �Ѵ�. �̷��� ������ �� Ư���� ������ ���� �͵��� �ִµ�, �̵��� ��ģ��(pinary number)�� �Ѵ�. ��ģ���� ������ ������ �����Ѵ�.
	
	��ģ���� 0���� �������� �ʴ´�.
	��ģ�������� 1�� �� �� �������� ��Ÿ���� �ʴ´�. ��, 11�� �κ� ���ڿ��� ���� �ʴ´�.
	���� ��� 1, 10, 100, 101, 1000, 1001 ���� ��ģ���� �ȴ�. 
	������ 0010101�̳� 101101�� ���� 1, 2�� ��Ģ�� ����ǹǷ� ��ģ���� �ƴϴ�.
	
	N(1 �� N �� 90)�� �־����� ��, N�ڸ� ��ģ���� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
	�Է�
	ù° �ٿ� N�� �־�����.
	
	���
	ù° �ٿ� N�ڸ� ��ģ���� ������ ����Ѵ�.
	
	���� �Է� 1 
	3
	���� ��� 1 
	2
 */
public class B_2193 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		/* ���� �� �ʱ�ȭ �κ� */
		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[91];
		arr[1] = 1;
		arr[2] = 1;
		for (int i = 3; i <= n; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		System.out.println(arr[n]);
	}
}
