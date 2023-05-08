package programmers;

import java.io.IOException;
/*
 * 문자열 압축 (카카오 2020) lv2
 */
public class KAKAO_2020_1 {
	public int solution(String s) {
        int answer = s.length();
        
        for (int i = 1; i <= s.length(); i++) {
        	//첫번째 반복문 : 문자열 쪼개는 단위의 수
        	String res = "";
        	int cnt = 1;
        	for (int j = 0; j < s.length(); j=j+i*cnt) {
        		if (j+i >= s.length()) {
        			res += s.substring(j);
        			break;
        		}
        		
        		String t = s.substring(j, j+i);
        		cnt = 1;
        		for (int k = j+i; k < s.length(); k+=i) {
        			String com = "";
        			if (k+i > s.length()) {
        				com = s.substring(k);
        			} else {
        				com = s.substring(k, k+i);
        			}
        			//System.out.println("t : "+ t+", com : " + com);
        			if (com.equals(t)) {
        				cnt++;
        				if (k+i >= s.length()) {
        					if (cnt > 1) res += cnt + t;
            				else res += t;
        					//System.out.println("t : "+ t+", res : " + res+"\n");
        				}
        			} else {
        				if (cnt > 1) res += cnt + t;
        				else res += t;
        				
        				//System.out.println("t : "+ t+", res : " + res+"\n");
        				break;
        			}	
        		}
        		
        	}
        	//System.out.println(res);
        	answer = Math.min(res.length(), answer);
        }
        
        return answer;
    }
	public void work() throws NumberFormatException, IOException {

		System.out.println(solution("aabbaccc"));
		System.out.println(solution("ababcdcdababcdcd"));
		System.out.println(solution("abcabcdede"));
		System.out.println(solution("abcabcabcabcdededededede"));
		System.out.println(solution("xababcdcdababcdcd"));
		
	}
}
