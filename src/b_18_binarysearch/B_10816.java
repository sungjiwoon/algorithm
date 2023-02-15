package b_18_binarysearch;

import java.io.*;
import java.util.*;
/*
 * ���� ī�� 2 ���� �ǹ�4
 * 
 
�ð� ����	�޸� ����	����	����	���� ���	���� ����
1 ��	256 MB	98109	36708	26284	36.459%
����
���� ī��� ���� �ϳ��� ������ �ִ� ī���̴�. ����̴� ���� ī�� N���� ������ �ִ�. ���� M���� �־����� ��, �� ���� �����ִ� ���� ī�带 ����̰� �� �� ������ �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ����̰� ������ �ִ� ���� ī���� ���� N(1 �� N �� 500,000)�� �־�����. ��° �ٿ��� ���� ī�忡 �����ִ� ������ �־�����. ���� ī�忡 �����ִ� ���� -10,000,000���� ũ�ų� ����, 10,000,000���� �۰ų� ����.

��° �ٿ��� M(1 �� M �� 500,000)�� �־�����. ��° �ٿ��� ����̰� �� �� ������ �ִ� ���� ī������ ���ؾ� �� M���� ������ �־�����, �� ���� �������� ���еǾ��� �ִ�. �� ���� -10,000,000���� ũ�ų� ����, 10,000,000���� �۰ų� ����.

���
ù° �ٿ� �Է����� �־��� M���� ���� ���ؼ�, �� ���� ���� ���� ī�带 ����̰� �� �� ������ �ִ����� �������� ������ ����Ѵ�.

���� �Է� 1 
10
6 3 2 10 10 10 -10 -10 7 3
8
10 9 -5 2 3 4 5 -10
���� ��� 1 
3 0 0 1 2 0 0 2
 */
public class B_10816 {
	static long[] a; 
	/* �̺� Ž�� �� �ݺ������� ���ѷ��� �������ʰ� ��������. st=mid �Ǵ� ���� �Ǻκ� ���ѷ����̴�!! */
	private static int upper(int st, int en, long k) {
		while (st < en) { //�������� ������ return
			int mid = (st+en) / 2;
			if (a[mid] > k) en = mid;
			else st = mid+1;
		}
		return st;
	}
	
	private static int lower(int st, int en, long k) {
		while (st < en) { //�������� ������ return
			int mid = (st+en) / 2;
			if (a[mid] >= k) en = mid;
			else st = mid+1;
		}
		return en;
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
			
			int start = upper(0, n, k);
			int end = lower(0, n, k);
			System.out.print(Math.abs(end-start) + " ");
		}					
			
	}
}
