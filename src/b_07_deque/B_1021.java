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
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] ms = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			ms[i] = Integer.parseInt(st.nextToken());
		}
		
		LinkedList<Integer> deq = new LinkedList<>();
		for (int i = 1; i <= N; i++) deq.add(i);
		
		int count = 0;
		for (int i = 0; i < M; i++) {
			int index = deq.indexOf(ms[i]);
			int half_index = deq.size()/2;
			
			if (index <= half_index) {
				while (ms[i] != deq.getFirst()) {
					deq.add(deq.removeFirst());
					count++;
				}
			} else {
				while (ms[i] != deq.getFirst()) {
					deq.addFirst(deq.removeLast());
					count++;
				}
			}
			deq.remove();
			
		}
		System.out.println(count);
		
	}
}
