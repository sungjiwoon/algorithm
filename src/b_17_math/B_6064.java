package b_17_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * ī�� �޷� ���дٱ���
 
�ð� ����	�޸� ����	����	����	���� ���	���� ����
1 ��	256 MB	56732	13954	10384	25.749%
����
�ֱٿ� ICPC Ž���� ���Ƹ޸�ī�� ��ī ������ ���� ������ ���� ī�� ������ ���� �Ͽ� �������ٴ� ����� �߰��ߴ�. ī�� ������ �鼺���� Ư���� �޷��� ����� ������ �˷��� �ִ�. �׵��� M�� N���� �۰ų� ���� �� ���� �ڿ��� x, y�� ������ �� �⵵�� <x:y>�� ���� �������� ǥ���Ͽ���. �׵��� �� ������ ���ʿ� �ش��ϴ� ù ��° �ظ� <1:1>�� ǥ���ϰ�, �� ��° �ظ� <2:2>�� ǥ���Ͽ���. <x:y>�� ���� �ظ� ǥ���� ���� <x':y'>�̶�� ����. ���� x < M �̸� x' = x + 1�̰�, �׷��� ������ x' = 1�̴�. ���� ������� ���� y < N�̸� y' = y + 1�̰�, �׷��� ������ y' = 1�̴�. <M:N>�� �׵� �޷��� ������ �طμ�, �� �ؿ� ������ ������ �����Ѵٴ� ������ ���� �´�.

���� ���, M = 10 �̰� N = 12��� ����. ù ��° �ش� <1:1>�� ǥ���ǰ�, 11��° �ش� <1:11>�� ǥ���ȴ�. <3:1>�� 13��° �ظ� ��Ÿ����, <10:12>�� �������� 60��° �ظ� ��Ÿ����.

�� ���� ���� M, N, x�� y�� �־��� ��, <M:N>�� ī�� �޷��� ������ �ض�� �ϸ� <x:y>�� �� ��° �ظ� ��Ÿ������ ���ϴ� ���α׷��� �ۼ��϶�.

�Է�
�Է� �����ʹ� ǥ�� �Է��� ����Ѵ�. �Է��� T���� �׽�Ʈ �����ͷ� �����ȴ�. �Է��� ù ��° �ٿ��� �Է� �������� ���� ��Ÿ���� ���� T�� �־�����. �� �׽�Ʈ �����ʹ� �� �ٷ� �����ȴ�. �� �ٿ��� �� ���� ���� M, N, x�� y�� �־�����. (1 �� M, N �� 40,000, 1 �� x �� M, 1 �� y �� N) ���⼭ <M:N>�� ī�� �޷��� ������ �ظ� ��Ÿ����.

���
����� ǥ�� ����� ����Ѵ�. �� �׽�Ʈ �����Ϳ� ����, ���� k�� �� �ٿ� ����Ѵ�. ���⼭ k�� <x:y>�� k��° �ظ� ��Ÿ���� ���� �ǹ��Ѵ�. ���� <x:y>�� ���� ǥ���Ǵ� �ذ� ���ٸ�, ��, <x:y>�� ��ȿ���� ���� ǥ���̸�, -1�� ����Ѵ�.

���� �Է� 1 
3
10 12 3 9
10 12 7 2
13 11 5 6
���� ��� 1 
33
-1
83
 */
public class B_6064 {
	private static int gcd(int m, int n) { //����� ���ϱ�
		if ( m == 0 ) return n;
		return gcd(n % m, m);
	}
	private static int lcm(int n, int m) {
		return n / gcd(n, m) * m;
	}
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		/* ���� �� �ʱ�ȭ �κ� */
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int m = Integer.parseInt(st.nextToken()); 
			int n = Integer.parseInt(st.nextToken()); 
			int x = Integer.parseInt(st.nextToken()); 
			int y = Integer.parseInt(st.nextToken()); 
			
			int res = -1;
			//�ּ� ����� ���ϱ�.
			int l = lcm(m,n);
			for (int i = 1; i <= l; i++) {
				if (l < x || l < y) break;
				if (i % m == x && i % n == y) {
					res = i;
					break;
				}
			}
			sb.append(res+"\n");
		}
		System.out.println(sb);
		
	}
}
 
