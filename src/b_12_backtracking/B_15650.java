package b_12_backtracking;

import java.util.Scanner;

/* ������ : N�� M 2
 * ���̵� : �ǹ� 3
 * ��Ʈ��ŷ �⺻ ���� 
 * ����
	�ڿ��� N�� M�� �־����� ��, �Ʒ� ������ �����ϴ� ���̰� M�� ������ ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
	1���� N���� �ڿ��� �߿��� �ߺ� ���� M���� �� ����
	�� ������ ���������̾�� �Ѵ�.
	
	�Է�
	ù° �ٿ� �ڿ��� N�� M�� �־�����. (1 �� M �� N �� 8)
	
	���
	�� �ٿ� �ϳ��� ������ ������ �����ϴ� ������ ����Ѵ�. �ߺ��Ǵ� ������ ���� �� ����ϸ� �ȵǸ�, �� ������ �������� �����ؼ� ����ؾ� �Ѵ�.
	
	������ ���� ������ �����ϴ� ������ ����ؾ� �Ѵ�.
	
	���� �Է� 1 
	3 1
	���� ��� 1 
	1
	2
	3
	���� �Է� 2 
	4 2
	���� ��� 2 
	1 2
	1 3
	1 4
	2 3
	2 4
	3 4
	���� �Է� 3 
	4 4
	���� ��� 3 
	1 2 3 4
 */

public class B_15650 {
	static int n, m;
	static int[] arr;
	static boolean[] isused;
	private static void func(int idx, int st) {
		if (idx == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		
		
		for (int i = st; i < n; i++) {
			if (!isused[i]) {
				isused[i] = true;
				arr[idx] = i+1;
				func(idx+1, i+1);
				isused[i] = false;
			}
		}
	}
	public void work() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[m];
		isused = new boolean[n];
		func(0, 0);
	}
}
