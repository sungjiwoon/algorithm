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
				//절대값 기준으로 두 값이 같다면 음수를 앞으로 보내준다.				
				if (Math.abs(o1) == Math.abs(o2)) {
					return o1.compareTo(o2); //비교해서 그대로 유지되거나 바꿔준다. 
				//절대값 기준으로 앞 값이 더 크다면 자리를 바꿔준다.	
				} else if (Math.abs(o1) > Math.abs(o2) ) {
					return Math.abs(o1)-Math.abs(o2); //양수 반환. -> 자리가 교체된다. 
				} else {
					return -1; //그대로 유지. -1, 0 -> 유지. 
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
