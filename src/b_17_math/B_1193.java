package b_17_math;

import java.io.*;
import java.util.*;
/*
 * �м�ã�� ���� �ǹ� 5
 
�ð� ����	�޸� ����	����	����	���� ���	���� ����
0.5 �� (�߰� �ð� ����)	256 MB	96657	48257	41671	51.231%
����
������ ū �迭�� ������ ���� �м����� �����ִ�.

1/1	1/2	1/3	1/4	1/5	��
2/1	2/2	2/3	2/4	��	��
3/1	3/2	3/3	��	��	��
4/1	4/2	��	��	��	��
5/1	��	��	��	��	��
��	��	��	��	��	��
�̿� ���� ������ �м����� 1/1 �� 1/2 �� 2/1 �� 3/1 �� 2/2 �� �� �� ���� ������� ������ ���ʴ�� 1��, 2��, 3��, 4��, 5��, �� �м���� ����.

X�� �־����� ��, X��° �м��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� X(1 �� X �� 10,000,000)�� �־�����.

���
ù° �ٿ� �м��� ����Ѵ�.

���� �Է� 1 
1
���� ��� 1 
1/1
���� �Է� 2 
2
���� ��� 2 
1/2

������ �� ����... ��û��!
 */
public class B_1193 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		/* ���� �� �ʱ�ȭ �κ� */
		
		//int n = Integer.parseInt(br.readLine());
		
		int K = 0;
		int a = 0; 
		int b = a;
		for (int n = 1; n <= 16; n++ ) {
		while (true) {			
			if (a < n && n <= b) {
				int x,y;		
				x = n-a;
				y = K- (n-a) + 1;
				
				if (K % 2 == 0)
					System.out.println(n+" : " + x+"/"+y);
				else 
					System.out.println(n+" : " + y+"/"+x);
				//return;
				break;
			} else {
				K++;
				a = b; 
				b += K;				
			}			
		}
		}
		
	}
}
