import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static boolean[] channel = new boolean[10];
	static final int MAX = 1000001;

	private static int solve() {
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			return Math.abs(o1-n) - Math.abs(o2-n);
		});

		int[] d = new int[MAX]; // 채널 갯수
		Arrays.fill(d, Integer.MAX_VALUE);

		// 만들 수 있는 채널은 모두 1이다.
		for (int i = 0; i < MAX; i++) {
			char[] ch = String.valueOf(i).toCharArray();
			boolean ok = true;
			for (int j = 0; j < ch.length; j++) {
				int idx = ch[j] - '0';
				if (!channel[idx]) {
					ok = false;
					break;
				}
			}
			if (ok) {
				d[i] = ch.length;
				pq.add(i);
			}
		}

		// 99 ~ 102 까지는 그냥 +1, -1 하는게 빠름.
		d[99] = 1;
		d[100] = 0;
		d[101] = 1;
		d[102] = 2;

		int near = pq.poll();
		int res = Math.abs(near - n) + d[near];
		if (res > d[n]) res = d[n];

		return res;

	}
	public static void main(String[] args) {
		input();
		System.out.println(solve());
	}
	private static void input() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			n = Integer.parseInt(br.readLine());

			Arrays.fill(channel, true);

			int m = Integer.parseInt(br.readLine());
			if (m == 0) return;

			int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


			for (int i = 0; i < m; i++) {
				channel[tmp[i]] = false;
			}

		} catch (Exception e) {}
	}
}
