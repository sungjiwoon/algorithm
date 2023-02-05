package b_15_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * ������ : �ĵ��ݼ���
 * ���̵� �ǹ�3
 * ����
	������ �׸��� ���� �ﰢ���� ���� ������� ������ �ִ�. ù �ﰢ���� ���ﰢ������ ���� ���̴� 1�̴�. �� �������� ������ ���� �������� ���ﰢ���� ��� �߰��Ѵ�. �������� ���� �� ���� ���̸� k�� ���� ��, �� ���� ���̰� k�� ���ﰢ���� �߰��Ѵ�.
	
	�ĵ��� ���� P(N)�� ������ �ִ� ���ﰢ���� ���� �����̴�. P(1)���� P(10)���� ù 10�� ���ڴ� 1, 1, 1, 2, 2, 3, 4, 5, 7, 9�̴�.
	
	N�� �־����� ��, P(N)�� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
	�Է�
	ù° �ٿ� �׽�Ʈ ���̽��� ���� T�� �־�����. �� �׽�Ʈ ���̽��� �� �ٷ� �̷���� �ְ�, N�� �־�����. (1 �� N �� 100)
	
	���
	�� �׽�Ʈ ���̽����� P(N)�� ����Ѵ�.
	
	���� �Է� 1 
	2
	6
	12
	���� ��� 1 
	3
	16
 */
public class B_9461 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		/* ���� �� �ʱ�ȭ �κ� */
		int T = Integer.parseInt(br.readLine());
		long[] arr = new long[101];
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 1;
		for (int i = 4; i <= 100; i++) {
			arr[i] = arr[i-2] + arr[i-3];
		}
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(arr[n]+"\n");
		}
		System.out.print(sb);
		
	}
}
