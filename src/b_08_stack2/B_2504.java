package b_08_stack2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/*
 * �ǹ� 1 (�̰� ��� �ǹ�1!!!!!!)
 * ����� ���� ��
 * ���� X... ^_^
 * Ǯ�̸� ã�ƺ��� ������ ����! �̰� �� �����ߴٰ� �ʹ� ��å���� ����..
 * ����� 90% ��� ������!!!!!!!!!!!!!!!!!!!!!!!! �׸���.
 * 
 */
public class B_2504 {
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		Stack<String> stack = new Stack<>();
		int sum = 0;
		int temp = 1;
		for (int i = 0; i < s.length(); i++) {
			String value = String.valueOf(s.charAt(i));
			switch (value) {
			case "(" :
				stack.push(value);
				temp *= 2;
				break;
			case "[" :
				stack.push(value);
				temp *= 3;
				break;
			case ")" :
				if (stack.isEmpty() || !stack.peek().equals("(")) {
					sum = 0;
					break;
				} 
				if (i >= 1 && s.charAt(i-1)=='(') sum += temp;
				stack.pop();
				temp /= 2;
				break;
			case "]" :
				if (stack.isEmpty() || !stack.peek().equals("[")) {
					sum = 0;
					break;
				} 
				if (i >= 1 && s.charAt(i-1)=='[') sum += temp;
				stack.pop();
				temp /= 3;
				break;			
			}
			
			
		}
		System.out.println(!stack.isEmpty() ? 0 : sum);
		
	}
}
