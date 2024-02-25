import java.io.*;
import java.util.*;

/** 240225 백준 리모컨 골드 5, 수학, 완탐 */

public class Main {
	static int n, same;
	static boolean[] channel = new boolean[10];

	private static boolean isOk (int num) {
		char[] ch = String.valueOf(num).toCharArray();
		for (int j = 0; j < ch.length; j++) {
			int idx = ch[j] - '0';
			if (channel[idx]) {
				return false;
			}
		}
		return true;
	}

	private static int solve() {

		int range = 0;
		int near = 100;
		boolean not100 = true;
		if (n == 100) not100 = false;

		while (range <= Math.abs(n - 100)) {

			int minus = n - range;
			if (minus >= 0 && isOk(minus)) {
				if (range + String.valueOf(minus).length() >= Math.abs(n - 100)) {
					minus = 100;
					not100 = false;
				}
				near = minus;
				break;
			}

			int plus = n + range;
			if (isOk(plus)) {
				if (range + String.valueOf(plus).length() >= Math.abs(n - 100)) {
					plus = 100;
					not100 = false;
				}
				near = plus;
				break;
			}

			if (range >= Math.abs(n - 100)) {
				near = 100;
				not100 = false;
				break;
			}

			range++;

		}

//        sb.append("near : " + near + ", not100 : " + not100+"\n");
		int len = not100 ? String.valueOf(near).length() : 0;
		int res = Math.abs(near - n) + len;
		return res;

	}
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			int flag = input(br);
			if (flag == -1 ) break;
			int ans = solve();
			if (ans != same) {
				sb.append("FAIL:" + n +" " + "ans : " + ans + ", res : " + same +"\n");
			}

		}
		System.out.println(sb);

	}
	private static int input(BufferedReader br) {
		try {
			String input = br.readLine();
			n = Integer.parseInt(input);
			if (n == -1) return -1;

			int m = Integer.parseInt(br.readLine());

			if (m != 0) {
				int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

				for (int i = 0; i < m; i++) {
					channel[tmp[i]] = true;
				}
			}

			same = Integer.parseInt(br.readLine());
			br.readLine();


		} catch (Exception e) {}
		return 0;
	}
}
