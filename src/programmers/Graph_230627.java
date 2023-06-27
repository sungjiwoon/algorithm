package programmers;
//https://school.programmers.co.kr/learn/courses/30/lessons/49191

/*
 * 플로이드 워샬 이용한 풀이. 
 * 순위를 아는 방법은, 모든 노드와 관계까 있는지 확인할 것. 
 */

public class Graph_230627 {
	public int solution(int n, int[][] results) {        

        int[][] floyd = new int[n+1][n+1]; //[i][j] = 1; -> i가 j한테 이겼다. 
        int[][] floyd2 = new int[n+1][n+1]; //[i][j] = 1; -> i가 j한테 졌다. 2가지 경우를 고려하여 플로이드 
        for (int i =1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                floyd[i][j] = 2000;
                floyd2[i][j] = 2000;
            }
        }
        
        for (int i =0; i < results.length; i++) {
            int a = results[i][0];
            int b = results[i][1];
            floyd[b][a] = 1;
            floyd2[a][b] = 1;
        }
        
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    floyd[i][j] = Math.min(floyd[i][j], floyd[i][k]+floyd[k][j]); 
                    floyd2[i][j] = Math.min(floyd2[i][j], floyd2[i][k]+floyd2[k][j]);
                }
            }
        }
        
       
        int answer = 0;
        for (int i = 1; i<= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                //System.out.print(floyd[i][j] + " ");
                if (floyd[i][j] != 2000) cnt++;
                if (floyd2[i][j] != 2000) cnt++;
            }
            //System.out.println();
            if (cnt == n-1) {
                answer++;
            }
        }

        return answer;
    }
}
