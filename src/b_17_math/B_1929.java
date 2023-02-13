package b_17_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * �Ҽ� ���ϱ� ����
 
�ð� ����	�޸� ����	����	����	���� ���	���� ����
2 ��	256 MB	226055	64145	45144	26.587%
����
M�̻� N������ �Ҽ��� ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� �ڿ��� M�� N�� �� ĭ�� ���̿� �ΰ� �־�����. (1 �� M �� N �� 1,000,000) M�̻� N������ �Ҽ��� �ϳ� �̻� �ִ� �Է¸� �־�����.

���
�� �ٿ� �ϳ���, �����ϴ� ������� �Ҽ��� ����Ѵ�.

���� �Է� 1 
3 16
���� ��� 1 
3
5
7
11
13

** ���� Ǯ�̹��� �ƴ� state �迭�� �������ν� �ð��� ������. 
 */
public class B_1929 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		/* ���� �� �ʱ�ȭ �κ� */
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		boolean[] state = new boolean[n+1]; //false => �Ҽ�. 
		
		Arrays.fill(state, true);
		state[1] = false;
		
		for (int i = 2; i * i <= n; i++) {
			if (!state[i]) continue;
			for (int j = i*i; j <= n; j+=i) {
				state[j] = false;

			}
		}
		for (int i = m; i <= n; i++) {
			if (state[i]) System.out.println(i);
		}
		
		
	}
}
