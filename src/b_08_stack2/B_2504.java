package b_08_stack2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_2504 {
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		Stack<String> stack = new Stack<>();
		int sum = 0;
		int temp = 0;
		boolean isVaild = true;
		for (int i = 0; i < s.length(); i++) {
			String value = String.valueOf(s.charAt(i));
			switch (value) {
			case "(" :
				stack.push(value);
				break;
			case "[" :
				stack.push(value);
				break;
			case ")" :
				if (stack.peek().equals("[")) {
					isVaild = false;
				} else if (stack.peek().equals("(")) {
					
				}
				break;
			case "]" :
				if (stack.peek().equals(")")) {
					isVaild = false;
				}
				break;				
			}
			if (!isVaild) {
				sum = 0;
				break;
			}
		}
		System.out.println(sum);
	}
}
