package b_05_stack;

import java.io.*;
import java.util.*;

/*
 * 외계인의 기타연주.
 * 스택의 배열 구조를 알았으면 좋았을 문제..^
 */
public class B_2841 {
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		Stack[] sks = new Stack[7];
		for (int i = 1; i <= 6; i++) sks[i] = new Stack<Integer>();
		int res = 0;
		
		for (int i= 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			Stack<Integer> sk = sks[n];
			if (sk.isEmpty()) {				
				sk.push(p);
				sb.append("push " + n + " " + p + "\n");
				res++;
			} else {
				if (sk.peek() < p) {
					sk.push(p);
					sb.append("push " + n + " " + p + "\n");
					res++;
				} else if (sk.peek() > p) {
					while (!sk.isEmpty() && sk.peek() > p) {
						sb.append("pop " + n + " " + sk.pop() + "\n");
						res++;
					}
					if (sk.isEmpty()) {
						sk.push(p);
						res++;
						sb.append("push " + n + " " + p + "\n");
					} else if (sk.peek() != p) {
						sk.push(p);
						sb.append("push " + n + " " + p + "\n");	
						res++;
					} 
				}
				
			}
			sks[n] = sk;
		}
		System.out.println("\n"+sb);
		System.out.println(res);
		
		
	}
}
