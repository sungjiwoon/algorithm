package b_12_backtracking;

import java.util.Scanner;
/*
 * ������ : N�� M
 * ���̵� : �ǹ�3
 * ����
	�ڿ��� N�� M�� �־����� ��, �Ʒ� ������ �����ϴ� ���̰� M�� ������ ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
	1���� N���� �ڿ��� �߿��� �ߺ� ���� M���� �� ����
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
	2 1
	2 3
	2 4
	3 1
	3 2
	3 4
	4 1
	4 2
	4 3
 */
public class B_15649 {
	static int n, m;
	static int[] arr;
	static boolean[] isused;
	private static void func(int idx) {
		if (idx == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			if (!isused[i]) {
				isused[i] = true;
				arr[idx] = i;
				func(idx+1);
				isused[i] = false;
			}
		}
	}
	public void work() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[m+1];
		isused = new boolean[n+1];
		func(0);
	}
}
