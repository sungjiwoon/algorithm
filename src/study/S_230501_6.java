package study;

import java.io.*;
import java.util.*;
/*
 * 문제: 프로그래머스 : [1차] 뉴스 클러스터링 
 * -> https://school.programmers.co.kr/learn/courses/30/lessons/17677
 * 난이도 lv2
 * 정규표현식 외우기..
 * 
 */
public class S_230501_6 {
	public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        ArrayList<String> g1 = new ArrayList<>();
        ArrayList<String> g2 = new ArrayList<>();
        String pattern = "^[a-z]*$";
        for (int i = 0; i < str1.length()-1; i++) {
        	String tmp = str1.substring(i, i+2);
        	if (tmp.matches(pattern)) {
        		g1.add(tmp);
        		System.out.print(tmp + " ");
        	}
        }
        System.out.println();
        for (int i = 0; i < str2.length()-1; i++) {
        	String tmp = str2.substring(i, i+2);
        	if (tmp.matches(pattern)) {
        		g2.add(tmp);
        		System.out.print(tmp + " ");
        	}
        }
        System.out.println();
        int size1 = g1.size();
        int size2 = g2.size();
        double gyo =0;
        for (int i = 0; i < size1; i++) {
        	for (int j = 0; j < size2; j++) {
        		if (g1.get(i).equals(g2.get(j))) {
        			gyo++;
        			g2.remove(j);
        			g2.add(j, "!");
        		   	System.out.println("gyo : " + g1.get(i));
        		   	break;
        		}
        	}
        }
        
        double hap = size1 + size2 - gyo;
        if (hap == 0 && gyo == 0) return 65536;
        answer = (int) Math.floor( (double) gyo / hap * 65536);
        //Math.round -> 소수점 반올림
        //Math.floor -> 소수점 버리기
          
        
        return answer;
    }
	public void work() throws NumberFormatException, IOException {
		System.out.println(solution("FRANCE", "french"));
		System.out.println(solution("handshake", "shake hands"));
		System.out.println(solution("aa1+aa2", "AAAA12"));
		System.out.println(solution("abab", "baba"));
	}
}
