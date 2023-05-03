package programmers;

import java.io.*;
import java.util.*;
//네트워크 lv 3
//dfs 활용.
public class P_230504_2 {
	static boolean[][] vis = new boolean[201][201];
	static boolean[] network = new boolean[201];
	static ArrayList<Integer> list;
	private void dfs(int[][] coms, int k, int n) {
		
		for (int i = 0; i < n; i++) {
			if (i == k) continue;
			if (coms[k][i] == 1 && !vis[k][i]) {
				list.add(i);
				vis[k][i] = true;
				vis[i][k] = true;
				dfs(coms, i, n);
			}
		}
		return;
		
	}
	public int solution(int n, int[][] computers) {
       
       int answer = 0;
       vis = new boolean[n][n];
       network = new boolean[n];
       for (int i = 0; i < n; i++) {
    	   list = new ArrayList<>();
    	   if (!network[i]) {
    		   list.add(i);
    		   dfs(computers, i, n);    		   
    		   for (int l : list) {
    			   System.out.print(l + " " );    			   
    			   network[l] = true;
    		   }
    		   answer++;
    		   System.out.println();
    		   
    	   }
       }        
       return answer;
    }
	public void work() throws NumberFormatException, IOException {
//		int[][] nums = {{1,1,0}, {1,1,1}, {0,1,1}};
		int[][] nums = {{1,0,0,0},{0,1,1,0}, {0,1,1,1}, {0,0,1,1}}; //0 / 123
		System.out.println(solution(4, nums));	
		
	}
}
