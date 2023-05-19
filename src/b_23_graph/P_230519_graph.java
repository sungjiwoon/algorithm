package b_23_graph;
import java.util.*;
import java.io.*;

/*
 * 가장 먼 노드 (lv 3)
 * n개의 노드가 있는 그래프가 있습니다. 각 노드는 1부터 n까지 번호가 적혀있습니다. 1번 노드에서 가장 멀리 떨어진 노드의 갯수를 구하려고 합니다. 
 * 가장 멀리 떨어진 노드란 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드들을 의미합니다.

	노드의 개수 n, 간선에 대한 정보가 담긴 2차원 배열 vertex가 매개변수로 주어질 때, 1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지를 return 하도록 solution 함수를 작성해주세요.
 */
public class P_230519_graph {
    static boolean[][] graph; 
    static boolean[][] vis;
    static int[] arr;
	 public int solution(int n, int[][] edge) {

	        TreeMap<Integer, ArrayList<Integer>> tm = new TreeMap<>();
	        for (int i = 0; i < edge.length; i++) {
	            int a = edge[i][0];
	            int b = edge[i][1];
	            if (tm.get(a) == null) {
	                ArrayList<Integer> list = new ArrayList<>();
	                list.add(b);
	                tm.put(a, list);
	            } else {
	                ArrayList<Integer> list = tm.get(a);
	                list.add(b);
	                tm.put(a, list);
	            }
	            
	             if (tm.get(b) == null) {
	                ArrayList<Integer> list = new ArrayList<>();
	                list.add(a);
	                tm.put(b, list);
	            } else {
	                ArrayList<Integer> list = tm.get(b);
	                list.add(a);
	                tm.put(b, list);
	            }
	        }
	        
	        arr = new int[n+1];
	        Arrays.fill(arr, n+3);
	        vis = new boolean[n+1][n+1];
	        
	        //bfs 부분 
	         Queue<Integer> qu = new LinkedList<>();
	         qu.add(1); //1부터 조사 시작. 
	         arr[1] = 0;
	         while (!qu.isEmpty()) {
	             int p = qu.poll(); 
	             ArrayList<Integer> list = tm.get(p);
	             if (list != null) {
	                 for (int l:list) {
	                     if (!vis[p][l]) {
	                         arr[l] = Math.min(arr[p]+1, arr[l]);
	                         qu.add(l);
	                         vis[p][l] = vis[l][p] = true;
	                     }
	                 }
	             }   
	            
	         }

	        arr[0] = arr[1] = -1;
	        Arrays.sort(arr);
	        int max = arr[n];
	        int answer = 0;
	        for (int i = n; i >= 1; i--) {
	            if (arr[i] == max) {
	               answer++; 
	            } else 
	                break;
	        }
	        
	        return answer;
	    }
}
