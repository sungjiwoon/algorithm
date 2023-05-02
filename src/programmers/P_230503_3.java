package programmers;

import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;
/*
 * 괄호 회전하기 (lv 2)
문제 설명
다음 규칙을 지키는 문자열을 올바른 괄호 문자열이라고 정의합니다.

(), [], {} 는 모두 올바른 괄호 문자열입니다.
만약 A가 올바른 괄호 문자열이라면, (A), [A], {A} 도 올바른 괄호 문자열입니다. 
예를 들어, [] 가 올바른 괄호 문자열이므로, ([]) 도 올바른 괄호 문자열입니다.
만약 A, B가 올바른 괄호 문자열이라면, AB 도 올바른 괄호 문자열입니다. 
예를 들어, {} 와 ([]) 가 올바른 괄호 문자열이므로, {}([]) 도 올바른 괄호 문자열입니다.
대괄호, 중괄호, 그리고 소괄호로 이루어진 문자열 s가 매개변수로 주어집니다. 
이 s를 왼쪽으로 x (0 ≤ x < (s의 길이)) 칸만큼 회전시켰을 때 
s가 올바른 괄호 문자열이 되게 하는 x의 개수를 return 하도록 solution 함수를 완성해주세요.
 */
public class P_230503_3 {
	public int solution(String s) {
        int answer = 0;        
        int size = s.length();
        for (int i = 0; i < size; i++) {
        	String t = s.substring(i, size);
        	t += s.substring(0,i);
        	boolean isOk = true;
        	Stack<Character> st = new Stack<>();
        	for (int j = 0; j < size; j++) {
        		char c = t.charAt(j);
        		if (c == '[' || c == '{' || c == '(') st.push(c);
        		else {
        			if (st.isEmpty()) isOk = false;
        			else if (c == ']') {
        				if (st.pop() != '[') isOk = false;
        			} else if (c == ')') {
        				if (st.pop() != '(') isOk = false;
        			} else if (c == '}') {
        				if (st.pop() != '{') isOk = false;
        			}
        		}
        		if (!isOk) {
        			System.out.println(t);
        			break;
        		}
        	}
        	if (st.isEmpty() && isOk) {
        		answer++;
        	}
        }
        
        return answer;
    }
	
	public void work() throws NumberFormatException, IOException {
//		System.out.println(solution("[](){}"));
//		System.out.println(solution("}]()[{"));
//		System.out.println(solution("[)(]"));	
		System.out.println(solution("((((("));	
		
	}
}
