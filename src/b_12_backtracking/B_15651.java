package b_12_backtracking;

import java.util.Scanner;

public class B_15651 {
	static int n, m;
	static int[] arr;
	static boolean[] isused;
	private static void func(int idx) {
		if (idx == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(arr[i]+ " ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i <= n; i++) {
				arr[idx] = i;
				func(idx+1);
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
