package programmers;

import java.io.*;
import java.util.*;

public class P_230504_4 {
	public int[] solution(String msg) {
		ArrayList<String> res = new ArrayList<>();
		ArrayList<Integer> res_n = new ArrayList<>();
		res.add("#");
        for (char c = 'A'; c <= 'Z'; c++) {
        	res.add(String.valueOf(c));
        }        
        int top = 27;
        for (int i = 0; i < msg.length(); i++) {
        	
        	boolean isInsert = false;
        	int len = 1; 
        	int n = 0;
        	while (!isInsert) {    
        		if (i+len > msg.length()) break;
        		String tmp = msg.substring(i, i+len);       		
        		if (res.contains(tmp)) {
        	      	len++;	
        	      	n = res.indexOf(tmp);
        	      	if (i+len == msg.length()+1) {
        	      		res_n.add(n);
        	      		break;
        	      	}
        		} else {
        			System.out.println(tmp);
        			res.add(tmp);
        			res_n.add(n);
        			isInsert= true;
        			i += tmp.length()-1;
        		}
        	}
        	
        }
        int[] answer = new int[res_n.size()];
        for (int i = 0; i < res_n.size(); i++) {
        	answer[i] = res_n.get(i);
        }
        
        return answer;
    }
	public void work() throws NumberFormatException, IOException {
		for (int i = 1; i < 60; i++)
			System.out.println(i % 60);
//		System.out.println(solution("TOBEORNOTTOBEORTOBEORNOT"));
		System.out.println(Arrays.toString(solution("KAKAO")));
	}
}
