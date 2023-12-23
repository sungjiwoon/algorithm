//package programmers;
//import java.util.*;
//public class 등대 {
//    ArrayList<Integer>[] graph;
//    int res = 0, N;
//    boolean[] vis;
//    public int dfs(int cur, int before) {
//
//        // 최소 객수 -> 리프노드들은 불이 꺼져있는게 좋음.
//        // 리프노드랑 연결된 애들을 불 켜진게 조음
//        // 리프 노드란? 연결된 노드의 갯수가 1개
//        if (graph[cur].size() == 1 && graph[cur].get(0) == before) {
//            //리프노드이면 불 킬필요가 없다.
//            return 1;
//        }
//
//        int sum = 0;
//        vis[cur] = true;
//        for (int nxt : graph[cur]) {
//            if (nxt == before) continue;
//            sum += dfs(nxt, cur);
//        }
//
//        if (sum == 0) {
//            //불을 킬 필요 없음.
//            return 1;
//        }
//
//        res++;
//        return 0;
//
//
//    }
//    public int solution(int n, int[][] lighthouse) {
//        init(n, lighthouse);
//        dfs(1, 0);
//        return res;
//    }
//    public void init(int n, int[][] lighthouse) {
//        graph = new ArrayList[n+1];
//        for (int i = 1; i <= n; i++) {
//            graph[i] = new ArrayList<>();
//        }
//
//        for (int i = 0; i < lighthouse.length; i++) {
//            int a = lighthouse[i][0];
//            int b = lighthouse[i][1];
//            graph[a].add(b);
//            graph[b].add(a);
//        }
//
//        N = n;
//        vis = new boolean[n+1];
//
//    }
//}
//
