package b_22_priority_queue;

import java.io.*;
import java.util.*;

public class B_11286 {
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> qu = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				//���밪 �������� �� ���� ���ٸ� ������ ������ �����ش�.				
				if (Math.abs(o1) == Math.abs(o2)) {
					return o1.compareTo(o2); //���ؼ� �״�� �����ǰų� �ٲ��ش�. 
				//���밪 �������� �� ���� �� ũ�ٸ� �ڸ��� �ٲ��ش�.	
				} else if (Math.abs(o1) > Math.abs(o2) ) {
					return Math.abs(o1)-Math.abs(o2); //��� ��ȯ. -> �ڸ��� ��ü�ȴ�. 
				} else {
					return -1; //�״�� ����. -1, 0 -> ����. 
				}
			}
			
		});
		
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				if (qu.isEmpty()) {
					sb.append("0\n");
				} else {
					sb.append(qu.poll()+"\n");
				}
 			} else {
				qu.add(x);
			}
		}
		System.out.println(sb);
	}
}
