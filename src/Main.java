import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringBuilder sb = new StringBuilder();

		int i = 0;
		while(i < s.length()) {
			if (s.charAt(i) == '<') { //태그 만나는 경우

				while (i < s.length() && s.charAt(i) != '>') {
					sb.append(s.charAt(i++));
				}
				sb.append(s.charAt(i++));

			} else if (s.charAt(i) == ' ') { //공백 만나는 경우

				sb.append(s.charAt(i++));

			} else { //그 밖에

				Stack<Character> stack = new Stack<>(); //문자열 뒤집기 도구.
				while (i < s.length() && s.charAt(i) != ' ' && s.charAt(i) != '<' && s.charAt(i) != '>') {
					stack.push(s.charAt(i++));
				}

				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}

			}
		}
		System.out.println(sb);
	
	}

}

