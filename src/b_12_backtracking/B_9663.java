package b_12_backtracking;

import java.util.Scanner;
/*���� : N-Queen
 * ���� ���̵� ��� 4
 * ��Ʈ��ŷ ��ƴ�.. 
 * ����
N-Queen ������ ũ�Ⱑ N �� N�� ü���� ���� �� N���� ���� ������ �� ���� ���� �����̴�.

N�� �־����� ��, ���� ���� ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� N�� �־�����. (1 �� N < 15)

���
ù° �ٿ� �� N���� ���� ������ �� ���� ���� ����� ���� ����Ѵ�.

���� �Է� 1 
8
���� ��� 1 
92


 */
public class B_9663 {
	static int n;
	static boolean[] isused1 = new boolean[40], 
			isused2 = new boolean[40], 
			isused3 = new boolean[40];
	static int cnt = 0;
	private static void func(int idx) {
		if (idx == n) {
			cnt++;
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (isused1[i] || isused2[i+idx] || isused3[idx-i+n-1]) continue;
			isused1[i] = true;
			isused2[i+idx] = true;
			isused3[idx-i+n-1] = true;
			func(idx+1);
			isused1[i] = false;
			isused2[i+idx] = false;
			isused3[idx-i+n-1] = false;
			
		}
	}
	public void work() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		func(0);
		System.out.println(cnt);
		
		
	}
}
