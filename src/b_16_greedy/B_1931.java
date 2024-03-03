package b_16_greedy;

import java.io.*;
import java.util.*;
/** 240303 백준 회의실 배정 실버 1 그리디 */
public class B_1931 {

	static PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
		if (o1[1] == o2[1]) return o1[0] - o2[0];
		return o1[1] - o2[1];
	});
	private static int solve() {
		int res = 0;

		while (!pq.isEmpty()) {
			int endTime = pq.poll()[1];
			while (!pq.isEmpty() && endTime > pq.peek()[0]) pq.poll();
			res++;
		}

		return res;
	}
	public static void main(String[] args) throws IOException {
		input();
		System.out.println(solve());
	}

	private static void input() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			pq.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
		}
	}
}
