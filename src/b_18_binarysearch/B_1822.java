package b_18_binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * ������ ����
 
�ð� ����	�޸� ����	����	����	���� ���	���� ����
2 ��	256 MB	6599	2929	2330	44.981%
����
�� ���� �ڿ����� �̷���� �� ���� A�� B�� �ִ�. ���� A���� ���ϸ鼭 ���� B���� ������ �ʴ� ��� ���Ҹ� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ��� ���� A�� ������ ���� n(A)�� ���� B�� ������ ���� n(B)�� �� ĭ�� ���̿� �ΰ� �־�����. (1 �� n(A), n(B) �� 500,000)�� �־�����. ��° �ٿ��� ���� A�� ���Ұ�, ��° �ٿ��� ���� B�� ���Ұ� �� ĭ�� ���̿� �ΰ� �־�����. �ϳ��� ������ ���Ҵ� 2,147,483,647 ������ �ڿ����̸�, �ϳ��� ���տ� ���ϴ� ��� ������ ���� �ٸ���.

���
ù° �ٿ� ���� A���� ���ϸ鼭 ���� B���� ������ �ʴ� ������ ������ ����Ѵ�. ���� �ٿ��� ��ü���� ���Ҹ� �� ĭ�� ���̿� �ΰ� �����ϴ� ������ ����Ѵ�. ���� A���� ���ϸ鼭 ���� B���� ������ �ʴ� ���Ұ� ���ٸ� ù° �ٿ� 0���� ����ϸ� �ȴ�.

���� �Է� 1 
4 3
2 5 11 7
9 7 4
���� ��� 1 
3
2 5 11
 */
public class B_1822 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		/* ���� �� �ʱ�ȭ �κ� */	
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n_a = Integer.parseInt(st.nextToken());
		int n_b = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int[] a = new int[n_a];
		for (int i = 0; i < n_a; i++) a[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int[] b = new int[n_b];
		for (int i = 0; i < n_b; i++) b[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		int cnt = 0;
		for (int i = 0; i < n_a; i++) {
			if (Arrays.binarySearch(b, a[i]) < 0) { 
				cnt++; 
				sb.append(a[i]+" ");
			}
		}
		sb.insert(0,cnt+"\n");
		System.out.println(sb);
			
	}
}
