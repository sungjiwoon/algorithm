package programmers;

import java.io.*;
import java.util.*;

public class P_230504_7 {
	static int cnt = 0;
    static ArrayList<Integer> list;
    private void dfs(String s, int len, String numbers, boolean[] vis) {
        if (s.length() == len) {
            int num = Integer.parseInt(s);
            System.out.println(num);
            if (num < 2 || list.contains(num)) return;
            if (num == 2) {
            	if (list.contains(num)) return;
            	cnt++;
            	list.add(num);
            	return;
            }
            for (int i = 2; i < Math.sqrt(num)+1; i++) {
                if (num % i == 0) return;
            }
            list.add(num);
            //System.out.println(num);
            
            cnt++;
            return;
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!vis[i]) {
                vis[i] = true;
                String tmp = s;
                s += String.valueOf(numbers.charAt(i));
                //System.out.println("vis : " + s);
                dfs(s, len, numbers, vis);
                s = tmp;
                vis[i] = false;
            }
        }
    }
	public int solution(String numbers) {
        int answer = 0;
        list = new ArrayList<Integer>();
        for (int i = 1; i <= numbers.length(); i++) {
            boolean[] vis = new boolean[numbers.length()];
            dfs("", i, numbers, vis);
        }
        answer = cnt;
        return answer;
    }
	public void work() throws NumberFormatException, IOException {
		//int[][] wires = {{1,3}, {2,3}, {3,4}, {4,5}, {4,6}, {4,7}, {7,8}, {7,9}};
//		int[][] wires = {{1,2}, {2,3}, {3,4}};
		System.out.println(solution("011"));
	}
}
