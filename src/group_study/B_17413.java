package group_study;

import java.io.*;
import java.util.*;
/*
단어뒤집기 (실3)
 */
public class B_17413 {
    public void work() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while(i < s.length()) {
            if (s.charAt(i) == '<') { //태그 만나는 경우

                while (i < s.length() && s.charAt(i) != '>') {
                    sb.append(s.charAt(i++));
                }
                sb.append(s.charAt(i++)); // '>' 삽입.

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
