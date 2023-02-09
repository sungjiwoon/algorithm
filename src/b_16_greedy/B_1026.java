package b_16_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * ���� ���� (�ǹ� 4)
 
	�ð� ����	�޸� ����	����	����	���� ���	���� ����
	2 ��	128 MB	46622	30286	25784	67.377%
	����
	���� ������ ������ �׻� ū ��ĩ�Ÿ����� ���� �־���. �� ������ ���� �������� ������ ���� ������ ���� ū ����� �ɾ���.
	
	���̰� N�� ���� �迭 A�� B�� �ִ�. ������ ���� �Լ� S�� ��������.
	
	S = A[0] �� B[0] + ... + A[N-1] �� B[N-1]
	
	S�� ���� ���� �۰� ����� ���� A�� ���� ��迭����. ��, B�� �ִ� ���� ��迭�ϸ� �� �ȴ�.
	
	S�� �ּڰ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
	�Է�
	ù° �ٿ� N�� �־�����. ��° �ٿ��� A�� �ִ� N���� ���� ������� �־�����, ��° �ٿ��� B�� �ִ� ���� ������� �־�����. N�� 50���� �۰ų� ���� �ڿ����̰�, A�� B�� �� ���Ҵ� 100���� �۰ų� ���� ���� �ƴ� �����̴�.
	
	���
	ù° �ٿ� S�� �ּڰ��� ����Ѵ�.
	
	���� �Է� 1 
	5
	1 1 1 6 0
	2 7 8 3 1
	���� ��� 1 
	18
 */
public class B_1026 {
	public void work() throws IOException {
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
			ans += a[i] * b[n-i-1]; //���� 
		}
		System.out.println(ans);
		
		
	}
}
