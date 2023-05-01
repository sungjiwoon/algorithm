package study;

import java.io.IOException;

/*
 * k진수에서 소수 개수 구하기 (lv2, 프로그래머스, 카카오2022)
 * https://school.programmers.co.kr/learn/courses/30/lessons/92335#qna
 * 
 * -> 2진수 변환시 글자 거꾸로 해놓는거 절대 잊지 말기!!!!
 */
public class S_230501_7 {
	private boolean is_prime(String st) {
		long num = Long.parseLong(st);
		if (num == 1) return false;
		if (num == 2) return true;
        for (long j = 2; j < Math.sqrt(num)+1; j++) {
            if (num % j == 0) {                    	
                return false;
            }
        }
        return true;
	}
	public int solution(int n, int k) {    
		String sb = "";
        int tmp = n;
        while (tmp > 0) {
            sb += String.valueOf(tmp%k);
            tmp /= k;
        }
        StringBuffer s = new StringBuffer(sb);
        s.reverse();
        sb = s.toString();
        System.out.println(n+" " + s);
        
        String[] arr = sb.split("0");
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
        	if (!arr[i].equals("") &&is_prime(arr[i])) {
        		System.out.println(arr[i] + " is prime number");
            	cnt++;
        	}
        }      
        
     
        return cnt;
    }	
	public void work() throws NumberFormatException, IOException {
		System.out.println(solution(437674, 3));
		System.out.println(solution(110011, 10));
		System.out.println(solution(00, 10));
		System.out.println(solution(2, 10));
		
	}
}
