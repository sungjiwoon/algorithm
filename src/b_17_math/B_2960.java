package b_17_math;
import java.io.*;
import java.util.*;

/*
 * �����佺�׳׽��� ü �����ٱ��� (�ǹ� 4)
 
	�ð� ����	�޸� ����	����	����	���� ���	���� ����
	1 ��	128 MB	22460	12309	10396	55.600%
	����
	�����佺�׳׽��� ü�� N���� �۰ų� ���� ��� �Ҽ��� ã�� ������ �˰����̴�.
	
	�� �˰����� ������ ����.
	
	2���� N���� ��� ������ ���´�.
	���� ������ ���� �� �� ���� ���� ���� ã�´�. �̰��� P��� �ϰ�, �� ���� �Ҽ��̴�.
	P�� �����, ���� ������ ���� P�� ����� ũ�� ������� �����.
	���� ��� ���� ������ �ʾҴٸ�, �ٽ� 2�� �ܰ�� ����.
	N, K�� �־����� ��, K��° ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
	�Է�
	ù° �ٿ� N�� K�� �־�����. (1 �� K < N, max(1, K) < N �� 1000)
	
	���
	ù° �ٿ� K��° ������ ���� ����Ѵ�.
	
	���� �Է� 1 
	7 3
	���� ��� 1 
	6
 */
public class B_2960 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		/* ���� �� �ʱ�ȭ �κ� */
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		boolean[] state = new boolean[n+1];
		Arrays.fill(state, true);
		state[1] = false;
		
		for (int i = 2; i <= n; i++) {
			int p = i;
			if (!state[p]) continue;
			for (int j = 2; j*j < p; j++) {
				if (p % j == 0) {
					state[p] = false; //�Ҽ� �ƴ�.
					break;
				}
			}
			if (state[p]) {
				//�Ҽ���. 
				cnt++;
				if (cnt == k) {
					System.out.println(p);
					return;
				}
				for (int j = p+p; j <= n; j+=p) {
					if (state[j]) {
						state[j] = false;
						cnt++;
						
						if (cnt == k) {
							System.out.println(j);
							return;
						}
					}
				}
			} 
		}
		
	}
}
