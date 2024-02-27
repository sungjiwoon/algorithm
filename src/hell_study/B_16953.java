package hell_study;

import java.io.*;
import java.util.*;
/** 240226 백준 A->B BFS, DFS, 그래프 탐색 */
public class B_16953 {

    private static void dfs(long num, long b, Map<Long, Integer> vis) {
        if (num > b) {
            return;
        }

        // * 2를 한다.
        long nxt = num * 2;
        if (nxt <= b && !vis.containsKey(nxt)) {
            vis.put(nxt, vis.get(num + 1));
            dfs(nxt, b, vis);
        }

        // 끝자리에 1을 더한다.
        nxt = num * 10 + 1;
        if (nxt <= b && !vis.containsKey(nxt)) {
            vis.put(nxt, vis.get(num + 1));
            dfs(nxt, b, vis);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        long a = Integer.parseInt(input[0]);
        long b = Integer.parseInt(input[1]);

        Map<Long, Integer> vis = new HashMap<>();
        vis.put(a, 0);
        dfs(a, b, vis);
//        vis.put(a, 0);
//
//        // bfs
//        Deque<Long> qu = new LinkedList<>();
//        qu.add(a);
//        while (!qu.isEmpty()) {
//            long q = qu.poll();
//            if (q == b) {
//                break;
//            }
//
//            long nxt = q * 2;
//
//            // 2를 곱한다.
//            if (nxt <= b && !vis.containsKey(nxt)) {
//                vis.put(nxt, vis.get(q) + 1);
//                qu.add(nxt);
//            }
//
//            // 끝자리에 1을 더한다.
//            nxt = q * 10 + 1;
//            if (nxt <= b && !vis.containsKey(nxt)) {
//                vis.put(nxt, vis.get(q) + 1);
//                qu.add(nxt);
//            }
//        }

        if (vis.containsKey(b)) {
            System.out.println(vis.get(b) + 1);
        } else {
            System.out.println(-1);
        }

        //dfs
    }
}
