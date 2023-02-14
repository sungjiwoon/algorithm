package b_17_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 * state ������ �̿��� �Ҽ� ���ϴ� �� �� �����α�.. ���� ���� : �����佺�׳׽��� ü ���� 2960 
 * ����Ʈ�� ���� �����ٱ���
 
�ð� ����	�޸� ����	����	����	���� ���	���� ����
1 ��	256 MB	92877	35412	28430	37.985%
����
����Ʈ�� ������ ������ �ڿ��� n�� ���Ͽ�, n���� ũ��, 2n���� �۰ų� ���� �Ҽ��� ��� �ϳ� �����Ѵٴ� ������ ��� �ִ�.

�� ������ ������ ����Ʈ���� 1845�⿡ �����߰�, ������Ƽ ü������� 1850�⿡ �����ߴ�.

���� ���, 10���� ũ��, 20���� �۰ų� ���� �Ҽ��� 4���� �ִ�. (11, 13, 17, 19) ��, 14���� ũ��, 28���� �۰ų� ���� �Ҽ��� 3���� �ִ�. (17,19, 23)

�ڿ��� n�� �־����� ��, n���� ũ��, 2n���� �۰ų� ���� �Ҽ��� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�. 

�Է�
�Է��� ���� ���� �׽�Ʈ ���̽��� �̷���� �ִ�. �� ���̽��� n�� �����ϴ� �� �ٷ� �̷���� �ִ�.

�Է��� ���������� 0�� �־�����.

���
�� �׽�Ʈ ���̽��� ���ؼ�, n���� ũ��, 2n���� �۰ų� ���� �Ҽ��� ������ ����Ѵ�.

����
1 �� n �� 123,456
���� �Է� 1 
1
10
13
100
1000
10000
100000
0
���� ��� 1 
1
4
3
21
135
1033
8392
 */
public class B_4948 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		/* ���� �� �ʱ�ȭ �κ� */
		int n = Integer.parseInt(br.readLine());
		int max = 123456*2+1;
		boolean[] state = new boolean[max];
		Arrays.fill(state, true);
		state[1] = false;
		for (int i = 2; i < max; i++) {
			if (!state[i]) continue;
			for (int j = 2; j*j < i; j++) {
				if (i % j == 0) {
					state[i] = false; //not �Ҽ�
					break;
				}
			}
			//�Ҽ� �� ��� ���� �Ҽ��� ����� ���� falseó��. 
			if (state[i]) {
				for (int j = i+i; j <= max; j+=i) {
					state[j] = false;
				}
			}
		}
		
		
		while (n != 0) {
			int cnt = 0;
			
			for (int i = n+1; i <= 2*n; i++) {
				if (state[i]) cnt++;
			}
			
			sb.append(cnt+"\n");
			n = Integer.parseInt(br.readLine());
		}
		System.out.println(sb);
		
	}
}
