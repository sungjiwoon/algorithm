package study_alone;

import java.util.*;
import java.io.*;

//선수과목
//위상정렬

public class B_14567 {
    static int n, m;
    static ArrayList<Integer>[] adj;
    static int[] indegree;
    public static void main(String[] args) {
        input();

        //선수 과목
        //위상 정렬
        //indegree 계산.

        int[] res = new int[n+1];

        Queue<Integer> qu = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                qu.offer(i);
                res[i] = 1;
            }
        }

        while (!qu.isEmpty()) {
            int q = qu.poll();

            for (int nxt : adj[q]) {
                indegree[nxt]--;
                if (indegree[nxt] == 0) {
                    qu.offer(nxt);
                    res[nxt] = res[q] + 1;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(res[i] + " ");
        }

    }
    private static void input() {
        try {
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(System.in));
            String[] sp = br.readLine().split(" ");
            n = Integer.parseInt(sp[0]);
            m = Integer.parseInt(sp[1]);

            adj = new ArrayList[n+1];
            for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
            indegree = new int[n+1];

            while (m-- > 0) {
                sp = br.readLine().split(" ");
                int a = Integer.parseInt(sp[0]);
                int b = Integer.parseInt(sp[1]);

                adj[a].add(b);
                indegree[b]++;
            }

        } catch(Exception e) {}
    }

}
