import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		
		while (!s.equals(".")) {
			
			Stack<String> stack = new Stack<>();
			boolean isok = true;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				String s1 = String.valueOf(c);
				
				if (c=='(' ||c == '[') {
					stack.push(s1);
				} else if (c==']') {
					if (stack.isEmpty() || stack.peek().equals("(") ) {
						isok = false;
						break;
					}else if (stack.peek().equals("[")) {
						stack.pop();
					} else {
						stack.push(s1);
					}
				} else if (c==')') {
					if (stack.isEmpty() || stack.peek().equals("]") ){
						isok = false;
						break;
					} else if (stack.peek().equals("(")) {
						stack.pop();
					} else {
						stack.push(s1);
					}
				}
				
			}
			if (!stack.isEmpty()) {
				isok = false;
			}
				
			if (isok) {					
				sb.append("yes\n");
			} else {
				sb.append("no\n");
			}
			s = br.readLine();
		}
		System.out.println(sb);
	}
}
