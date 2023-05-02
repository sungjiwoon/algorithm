package programmers;

import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;
/*
 * ��ȣ ȸ���ϱ� (lv 2)
���� ����
���� ��Ģ�� ��Ű�� ���ڿ��� �ùٸ� ��ȣ ���ڿ��̶�� �����մϴ�.

(), [], {} �� ��� �ùٸ� ��ȣ ���ڿ��Դϴ�.
���� A�� �ùٸ� ��ȣ ���ڿ��̶��, (A), [A], {A} �� �ùٸ� ��ȣ ���ڿ��Դϴ�. 
���� ���, [] �� �ùٸ� ��ȣ ���ڿ��̹Ƿ�, ([]) �� �ùٸ� ��ȣ ���ڿ��Դϴ�.
���� A, B�� �ùٸ� ��ȣ ���ڿ��̶��, AB �� �ùٸ� ��ȣ ���ڿ��Դϴ�. 
���� ���, {} �� ([]) �� �ùٸ� ��ȣ ���ڿ��̹Ƿ�, {}([]) �� �ùٸ� ��ȣ ���ڿ��Դϴ�.
���ȣ, �߰�ȣ, �׸��� �Ұ�ȣ�� �̷���� ���ڿ� s�� �Ű������� �־����ϴ�. 
�� s�� �������� x (0 �� x < (s�� ����)) ĭ��ŭ ȸ�������� �� 
s�� �ùٸ� ��ȣ ���ڿ��� �ǰ� �ϴ� x�� ������ return �ϵ��� solution �Լ��� �ϼ����ּ���.
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
