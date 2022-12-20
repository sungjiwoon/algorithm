package b_07_deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
/*
 * 골드 5 문제
 * 덱이용
 * 덱은 LinkedList<Integer> 를 사용하는게 훨씬 효과적 
 * 방향바꾸고 싶을 땐 그냥 if문과 boolean 쓰는게 더 효과적이다!!!
 * 
 */

public class B_5430 {
	public void work() throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			
			String ac = br.readLine();
			
			/* 숫자 배열 받기 */
			int n = Integer.parseInt(br.readLine());
			String s = br.readLine();			
			String[] ns = s.substring(1, s.length()-1).split(",");
			LinkedList<Integer> deq = new LinkedList<>();
			for (int i = 0; i < n; i++) {
				deq.addFirst(Integer.parseInt(ns[i]));
			}
			
			boolean iserror = false; //에러인지 아닌지 확인용.
			boolean isRight = true; //R일때 방향 체인지 하는 변수. 
			for (int i = 0; i < ac.length(); i++) {
				
				if (ac.substring(i, i+1).equals("R") ) { //직접 배열 넣으면 시간초과가 나서 출력문의 방향을 바꿔주는 쪽으로 가야함. 
					isRight = !isRight;
				} else  if (ac.substring(i, i+1).equals("D") ){
					if (!deq.isEmpty()) {
						if (isRight)
							deq.removeLast();
						else
							deq.removeFirst();
					} else {
						iserror=true;
						break;
					}
				}
			}
			
			if (iserror) {
				sb.append("error\n");
			} else {
				sb.append("[");
				while (!deq.isEmpty()) {
					if (isRight) {
						if (deq.size() > 1)
							sb.append(deq.removeLast()+",");
						else
							sb.append(deq.removeLast());
					} else {
						if (deq.size() > 1)
							sb.append(deq.removeFirst()+",");
						else
							sb.append(deq.removeFirst());
					}
				}
				sb.append("]\n");					
			}				
						
			
		}
		System.out.print(sb);
		
	}
}
