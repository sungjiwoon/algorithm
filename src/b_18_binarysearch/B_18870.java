package b_18_binarysearch;

import java.io.*;
import java.util.*;
/*
 * ��ǥ ���� ����
 �ǹ� 2
 -> �ߺ��迭 ���� �� ���� �Լ��� �Ẽ�� ������, hashmap�� ���� �����ϰ� �ذ�ȴ�!
�ð� ����	�޸� ����	����	����	���� ���	���� ����
2 ��	512 MB	57365	24020	18368	39.689%
����
������ ���� N���� ��ǥ X1, X2, ..., XN�� �ִ�. �� ��ǥ�� ��ǥ ������ �����Ϸ��� �Ѵ�.

Xi�� ��ǥ ������ ��� X'i�� ���� Xi > Xj�� �����ϴ� ���� �ٸ� ��ǥ�� ������ ���ƾ� �Ѵ�.

X1, X2, ..., XN�� ��ǥ ������ ������ ��� X'1, X'2, ..., X'N�� ����غ���.

�Է�
ù° �ٿ� N�� �־�����.

��° �ٿ��� ���� �� ĭ���� ���е� X1, X2, ..., XN�� �־�����.

���
ù° �ٿ� X'1, X'2, ..., X'N�� ���� �� ĭ���� �����ؼ� ����Ѵ�.

����
1 �� N �� 1,000,000
-109 �� Xi �� 109
���� �Է� 1 
5
2 4 -10 4 -9
���� ��� 1 
2 3 0 3 1
 */
public class B_18870 {
	
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		/* ���� �� �ʱ�ȭ �κ� */	
		
		int n = Integer.parseInt(br.readLine());
		long[] a = new long[n];
		long[] sorted = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < n; i++) 
			sorted[i] = a[i] = Long.parseLong(st.nextToken());

		Arrays.sort(sorted);
		
		Map<Long, Integer> hs = new HashMap<>();
		
		int rank = 0;
		for (int i = 0; i < n; i++) {
			if (hs.get(sorted[i]) == null) {
				hs.put(sorted[i], rank); //hashmap�� ������ ���Ұ� ������ ���� �־���. 
				rank++;
			} 
		}
		
		for (long l : a) {
			sb.append(hs.get(l)+" ");
		}
		System.out.println(sb);
			
	}
}
