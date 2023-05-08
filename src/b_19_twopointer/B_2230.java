package b_19_twopointer;

import java.io.*;
import java.util.*;
/*
 * �� ���� ����
 
	�ð� ����	�޸� ����	����	����	���� ���	���� ����
	2 ��	128 MB	14680	4829	3387	30.352%
	����
	N���� ������ �̷���� ���� A[1], A[2], ��, A[N]�� �ִ�. 
	�� �������� �� ���� ����� ��(���� ���� ���� �ִ�), 
	�� ���̰� M �̻��̸鼭 ���� ���� ��츦 ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
	���� ��� ������ {1, 2, 3, 4, 5}��� ����. 
	���� M = 3�� ���, 1 4, 1 5, 2 5�� ����� �� �� ���̰� M �̻��� �ȴ�. 
	�� �߿��� ���̰� ���� ���� ���� 1 4�� 2 5�� ����� ���� 3�� �ȴ�.
	
	�Է�
	ù° �ٿ� �� ���� N, M�� �־�����. 
	���� N���� �ٿ��� ���ʷ� A[1], A[2], ��, A[N]�� �־�����.
	
	���
	ù° �ٿ� M �̻��̸鼭 ���� ���� ���̸� ����Ѵ�. �׻� ���̰� M�̻��� �� ���� �� �� �ִ�.
	
	���� �Է� 1 
	3 3
	1
	5
	3
	���� ��� 1 
	4
 */
public class B_2230 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		/* ���� �� �ʱ�ȭ �κ� */	
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long[] a = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(a);
		
		int start = 0, end = 1;
		long min = Long.MAX_VALUE;
		
		while (start < n && end < n) {
			
			while (Math.abs(a[end]-a[start]) < m) {
				if (end == n-1) break;
				end++;
				//System.out.println(end);
			}
			if (a[end]-a[start] == m) {
				min = m;
				break;
			} else if (a[end]-a[start] > m) {
				min = Math.abs(a[end]-a[start]);
			}
			start++;
			//System.out.println(a[start] + "," + a[end]);
			
		}
		System.out.println(min);
		
			
	}
}
