package b_17_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 * ���丮�� 0�� ���� ���� (�ǹ�5)
 
�ð� ����	�޸� ����	����	����	���� ���	���� ����
2 ��	128 MB	56500	27210	22487	47.903%
����
N!���� �ڿ������� ó�� 0�� �ƴ� ���ڰ� ���� ������ 0�� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� N�� �־�����. (0 �� N �� 500)

���
ù° �ٿ� ���� 0�� ������ ����Ѵ�.

���� �Է� 1 
10
���� ��� 1 
2
���� �Է� 2 
3
���� ��� 2 
0
 */
public class B_1676 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		/* ���� �� �ʱ�ȭ �κ� */
		int n = Integer.parseInt(br.readLine());
		int i = 1;
		int cnt = 0; //10���� �������� ����;
		int cnt2 = 0; //2�� �������� ����
		int cnt5 = 0; //5�� �������� ����.
		/* i�� ���� 10���� ���������� 2,5 �Ѵ� Ȥ�� 10�� ���μ��� �������� */
		// ex 25 �� ��� -> 5�� �ι� ��������ϹǷ� �ݺ��� �ѹ� �� ����. 
		while (i <= n) {
			int tmp = i;
			while (tmp != 0) {
				if (tmp % 10 == 0) {
					cnt++;
					tmp /= 10;
				}
				else if (tmp % 5 == 0) {
					cnt5++;
					tmp /= 5;
				}
				else if (tmp % 2 == 0) {
					cnt2++;
					tmp /= 2;
				} else {
					break;
				}				
			}
			i++;
		}
		int res = 0;
		if (cnt2 >= cnt5) res += cnt5;
		else res += cnt2;
		res += cnt;
		System.out.println(res);
		
	}
}
