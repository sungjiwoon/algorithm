package b_08_stack2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 스택의 괄호쌍. 연습
 * 답지 안봤지만 시간이 꽤나 오래 걸림.
 * 
 */

public class B_10799 {
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();		
		Stack<String> stack = new Stack<>();
		int sum = 0;
		boolean ispop = false;
		for (int i = 0; i < s.length(); i++) {
			
			String value = String.valueOf(s.charAt(i));
			
			if (value.equals("(")) {
				stack.push("(");
				ispop = false;
			
			} else if (value.equals(")")) {
				stack.pop();
				
				if (!ispop) {	
					sum += stack.size();
				} else {
					sum++;
				}
				ispop = true;
									
			}			
			
		}
		System.out.println(sum);
		
	}
}
