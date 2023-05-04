package programmers;

import java.io.*;
import java.util.*;
/*
 * 단어변환 (lv 3) 
 * dfs 로 풀었다. 
 * https://school.programmers.co.kr/learn/courses/30/lessons/43163
 */
public class P_230504_3 {
	static int min;
	
	private void dfs(String[] words, String target, String begin, int cnt, boolean[] vis) {
		
		if (target.equals(begin)) {
			min = Math.min(cnt, min);
			return;
		}
		
		//단어의 길이로 쪼갠다. 단어 만들기. 
		int size = begin.length();
		
		for (int i = 0; i < size; i++) {
			String tmp = begin.substring(0, i) + "#" + begin.substring(i+1, size);				
			//System.out.println("tmp " + begin + ", " + tmp);
			for (int j = 0; j < words.length; j++) {
				if (vis[j]) continue;
				
				String compare = words[j].substring(0,i) + "#" + words[j].substring(i+1,size);
				
				//System.out.println(Arrays.toString(vis));
				if (tmp.equals(compare)) {
					//System.out.println("tmp " + begin + ", " + tmp);	
					//System.out.println("compare " + words[j] + ", "+compare);
					//System.out.println(Arrays.toString(vis));
					vis[j] = true;
					dfs(words, target, words[j], cnt+1, vis);
					vis[j] = false;
				}
			}
		}
		
		
	}
	public int solution(String begin, String target, String[] words) {
        int answer = 0;
        min = words.length;
        ArrayList<String> list = new ArrayList<String>();
        dfs(words, target, begin, 0, new boolean[words.length]);
        if (min == words.length) answer = 0;
        else answer = min;
        return answer;
    }
	public void work() throws NumberFormatException, IOException {
//		int[][] nums = {{1,1,0}, {1,1,1}, {0,1,1}};
		String[] words = {"hot", "dot", "dog", "lot", "log"};
		System.out.println(solution("hit", "cog", words));	
		
	}
}
