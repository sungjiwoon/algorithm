package programmers;

import java.io.*;
import java.util.*;

public class P_230503 {
	public int[] solution(String s) {
        int[] answer = new int[2];
        int c0 = 0, c1 = 0;
        
        while (true) {
            int s_len = s.length(); //���� s�� ����
            String tmp = s.replaceAll("0", "");
            int t_len = tmp.length(); //��ȯ�� s�� ����
            int c = s_len-t_len;
            //System.out.println(tmp + " \n������ 0�� ���� : " + c+"\n");
            if (tmp.equals("1")) {
                answer[0] = c0+1;
                answer[1] = c1+c;
                break;
            } else {
                c0++;
                c1 +=c;
            }
            s = "";
            
            while (t_len > 0) {
                s += t_len % 2;
                t_len /= 2;
            }
            StringBuilder sb = new StringBuilder(s);
            sb.reverse();
            s = String.valueOf(sb);
            //System.out.println("������ȯ ��� " + s);
            
        }
        return answer;
    }
	public void work() throws NumberFormatException, IOException {
		System.out.println(Arrays.toString(solution("110010101001")));
		System.out.println(Arrays.toString(solution("01110")));
		System.out.println(Arrays.toString(solution("1111111")));
		
		
	}
}
