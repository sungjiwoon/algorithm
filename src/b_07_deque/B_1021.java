package b_07_deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B_1021 {
	public void work() throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] ms = new int[m]; //순서.
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			ms[i] = Integer.parseInt(st.nextToken());
		}
		
		LinkedList<Integer> deq = new LinkedList<>();

		for (int i = 1; i <= n; i++) deq.addLast(i);

		int ans = 0;
		for (int i = 0; i < m; i++) {

			int index = deq.indexOf(ms[i]);
			int half_index = deq.size() / 2;
			// 중간 지점보다 앞에 있으면 2번, 뒤에 있으면 3번 연산.

			//2
			if (index <= half_index) {
				//2
				while (deq.peekFirst() != ms[i]) {
					deq.addLast(deq.pollFirst());
					ans++;
				}
			} else {
				//3
				while (deq.peekFirst() != ms[i]) {
					deq.addFirst(deq.pollLast());
					ans++;
				}
			}

			deq.pollFirst();

		}

		System.out.println(ans);

		
	}
}
