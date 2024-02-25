package b_09_bfs;

import java.io.*;
import java.util.*;

/** 240225 백준 뱀과 사다리 게임 골드 5 BFS */

/**
 * 넓이 우선 탐색이되, 방문한 지점의 주사위 횟수 갯수로 판단.
 */

public class B_16928 {
    static int[] map = new int[101];

    private static int solve() {
        int[] d = new int[101]; // 주사위 횟수 담는 배열.
        Arrays.fill(d, Integer.MAX_VALUE);

        Queue<Integer> qu = new LinkedList<>();
        qu.add(1);
        d[1] = 0;
        while (!qu.isEmpty()) {
            int q = qu.poll();
            if (q == 100) break;
            for (int k = 1; k <= 6; k++) {
                int nxt = q + k;
                if (nxt > 100) break;

                if (map[nxt] >= 1) {
                    nxt = map[nxt];
                }

                if (d[nxt] <= d[q]) continue;

                d[nxt] = Math.min(d[q] + 1, d[nxt]);
                qu.add(nxt);
            }
        }

        int res = d[100];
        return res;
    }

    public static void main(String[] args) {
        input();
        System.out.println(solve());
    }
    private static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = tmp[0];
            int m = tmp[1];

            for (int i = 0; i < n; i++) {
                tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                map[tmp[0]] = tmp[1];
            }

            for (int i = 0; i < m; i++) {
                tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                map[tmp[0]] = tmp[1];
            }

        } catch (Exception e) {}
    }
}
