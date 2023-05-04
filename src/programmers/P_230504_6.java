package programmers;

import java.io.*;
import java.util.*;
/*
 * 전력망을 둘로 나누기 (완전탐색 ,lv2)
 * https://school.programmers.co.kr/learn/courses/30/lessons/86971
 */
public class P_230504_6 {
	public int solution(int n, int[][] wires) {
        int answer = n;
        
        for (int i = 0; i < wires.length; i++) {
            Queue<Integer> qu = new LinkedList<>();
            int v1 = 0, v2 = 0;
            int tmp1 = wires[i][0];
            int tmp2 = wires[i][1];
            wires[i][0] = 0;
            wires[i][1] = 0;
            
			boolean[] vis = new boolean[n+1];
			
			qu.add(1);            
            vis[1] = true;            
            while (!qu.isEmpty()) {
                int q = qu.poll();
                for (int k =0; k < wires.length; k++) {
                    //if (vis[k]) continue;
                    int w1 = wires[k][0];
                    int w2 = wires[k][1];
                    if (w1 == q) {
                        if (!vis[w2]) {
                            vis[w2] = true;
                            qu.add(w2);
                        } 
                    } else if (w2 == q) {
                        if (!vis[w1]) {
                            vis[w1] = true;
                            qu.add(w1);
                        } 
                    }
                }
            }
            for (int k = 1; k <= n; k++) {
            	if (vis[k]) {
            		System.out.print(k + " ");
            		v1++;
            	}
            }
            
            v2 = n - v1;
            System.out.println("\nanswer : " + Math.abs(v1-v2)+"\n");
            answer = Math.min(Math.abs(v1-v2), answer);
            
            wires[i][0] = tmp1;
            wires[i][1] = tmp2;
        }
        
        return answer;
    }
	public void work() throws NumberFormatException, IOException {
		int[][] wires = {{1,3}, {2,3}, {3,4}, {4,5}, {4,6}, {4,7}, {7,8}, {7,9}};
//		int[][] wires = {{1,2}, {2,3}, {3,4}};
		System.out.println(solution(9, wires));
	}
}
