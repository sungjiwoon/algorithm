package b_07_deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
/*
 * ��� 5 ����
 * ���̿�
 * ���� LinkedList<Integer> �� ����ϴ°� �ξ� ȿ���� 
 * ����ٲٰ� ���� �� �׳� if���� boolean ���°� �� ȿ�����̴�!!!
 * 
 */

public class B_5430 {
	public void work() throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			
			String ac = br.readLine();
			
			/* ���� �迭 �ޱ� */
			int n = Integer.parseInt(br.readLine());
			String s = br.readLine();			
			String[] ns = s.substring(1, s.length()-1).split(",");
			LinkedList<Integer> deq = new LinkedList<>();
			for (int i = 0; i < n; i++) {
				deq.addFirst(Integer.parseInt(ns[i]));
			}
			
			boolean iserror = false; //�������� �ƴ��� Ȯ�ο�.
			boolean isRight = true; //R�϶� ���� ü���� �ϴ� ����. 
			for (int i = 0; i < ac.length(); i++) {
				
				if (ac.substring(i, i+1).equals("R") ) { //���� �迭 ������ �ð��ʰ��� ���� ��¹��� ������ �ٲ��ִ� ������ ������. 
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
