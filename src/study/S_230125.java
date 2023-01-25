package study;

import java.util.*;
import java.io.*;
//¸Â­ŸÀ½. 
//¹®Á¦¸í : ÃÖ´Ü°æ·Î 
class Pair {
    int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class S_230125 {
	static Queue<Pair> qu = new LinkedList<>(); 
	static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
	static int[][] dis;
    public int solution(int[][] maps) {
    	int n = maps.length;
    	int m = maps[0].length;
    	dis = new int[n][m];
    	qu.offer(new Pair(0,0));
    	dis[0][0] = 0;
       
    	while (!qu.isEmpty()) {
    		Pair p = qu.poll();
    		for (int k = 0; k < 4; k++) {
    			int xx = p.x+dx[k];
    			int yy = p.y+dy[k];
    			if (xx < 0 || yy < 0 || xx >= n || yy >= m) continue;
    			if (maps[xx][yy] == 1 && dis[xx][yy] == 0) {
    				qu.offer(new Pair(xx, yy));
    				dis[xx][yy] = dis[p.x][p.y]+1;
    			}
    			if (xx == n-1 && yy == m-1) {
    				return dis[xx][yy];
    			}
    		}
    	}
       return -1;
    }
   
}
