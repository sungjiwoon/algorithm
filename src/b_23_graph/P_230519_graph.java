package b_23_graph;
import java.util.*;
import java.io.*;

/*
 * ���� �� ��� (lv 3)
 * n���� ��尡 �ִ� �׷����� �ֽ��ϴ�. �� ���� 1���� n���� ��ȣ�� �����ֽ��ϴ�. 1�� ��忡�� ���� �ָ� ������ ����� ������ ���Ϸ��� �մϴ�. 
 * ���� �ָ� ������ ���� �ִܰ�η� �̵����� �� ������ ������ ���� ���� ������ �ǹ��մϴ�.

	����� ���� n, ������ ���� ������ ��� 2���� �迭 vertex�� �Ű������� �־��� ��, 1�� ���κ��� ���� �ָ� ������ ��尡 �� �������� return �ϵ��� solution �Լ��� �ۼ����ּ���.
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
	        
	        //bfs �κ� 
	         Queue<Integer> qu = new LinkedList<>();
	         qu.add(1); //1���� ���� ����. 
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
