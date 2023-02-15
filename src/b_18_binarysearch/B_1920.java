package b_18_binarysearch;

import java.io.*;
import java.util.*;
/*
 * �� ã�� ���� �ǹ� 4 / �̺�Ž��
 
�ð� ����	�޸� ����	����	����	���� ���	���� ����
1 ��	128 MB	186953	56392	37459	29.867%
����
N���� ���� A[1], A[2], ��, A[N]�� �־��� ���� ��, �� �ȿ� X��� ������ �����ϴ��� �˾Ƴ��� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� �ڿ��� N(1 �� N �� 100,000)�� �־�����. ���� �ٿ��� N���� ���� A[1], A[2], ��, A[N]�� �־�����. ���� �ٿ��� M(1 �� M �� 100,000)�� �־�����. ���� �ٿ��� M���� ������ �־����µ�, �� ������ A�ȿ� �����ϴ��� �˾Ƴ��� �ȴ�. ��� ������ ������ -231 ���� ũ�ų� ���� 231���� �۴�.

���
M���� �ٿ� ���� ����Ѵ�. �����ϸ� 1��, �������� ������ 0�� ����Ѵ�.

���� �Է� 1 
5
4 1 5 2 3
5
1 3 7 9 5
���� ��� 1 
1
1
0
0
1
 */
public class B_1920 {
	static long[] a;

	private static int binary_search(int start, int end, long k) {
		
		while (start <= end) {
			int mid = (start + end) / 2;
			if (a[mid] < k) {
				start = mid+1;
			} else if (a[mid] > k) {
				end = mid-1;
			} else 
				return 1;
		} 
		return 0;
			
		
	}
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		/* ���� �� �ʱ�ȭ �κ� */	
		
		int n = Integer.parseInt(br.readLine());
		a = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) a[i] = Long.parseLong(st.nextToken());
		Arrays.sort(a);
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < m; i++) {
			long k = Long.parseLong(st.nextToken());
			System.out.println(binary_search(0, n-1, k));
		}					
			
	}
}
