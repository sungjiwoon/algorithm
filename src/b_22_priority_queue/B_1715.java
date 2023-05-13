package b_22_priority_queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
//ī�� ������ ���4, 
// �켱����ť�� �ذ��Ͽ���. 
public class B_1715 {
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> qu = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			int k =  Integer.parseInt(br.readLine());
			qu.add(k);
		}
		int res = 0;
		while (!qu.isEmpty()) {
			if (qu.size() > 1) {
				int a = qu.poll();
				int b = qu.poll();
				qu.add(a+b);
				sb.append(a+b+"\n");
				res += a+b;
				sb.append("res : " + res+"\n");
			} else {
				qu.poll();
			}
		}
		System.out.println(sb);
		System.out.println(res);
	}
}
