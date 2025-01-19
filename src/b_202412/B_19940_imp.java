package b_202412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/** 240119 그리디, BFS 피자오븐 https://www.acmicpc.net/problem/19940 */
public class B_19940_imp {

    int n;
    int[] T;
    int[] dp;
    int[][] count;
    final int N = 60;

    void bfs() {
        int[] dx = {60, 10, -10, 1, -1};
        Queue<Integer> qu = new LinkedList<>();
        Arrays.fill(dp, N+10);
        dp[0] = 0;
        qu.add(0);

        while (!qu.isEmpty()) {
            int p = qu.poll();
            System.out.println("p= " + p + " dp["+p+"]= " + dp[p]);

            for (int i = 4; i >= 0; i--) {
                int np = p + dx[i];
                if (np < 0 || np > 60) continue;
                if (dp[np] > dp[p] + 1) {
                    dp[np] = dp[p] + 1;
                    qu.add(np);
                    count[np] = Arrays.copyOf(count[p], 5);
                    count[np][i]++;
                }
            }
        }

        for (int j = 0; j <= N; j++) {
            System.out.print(j+": ");
            for (int i = 0; i < 5; i++) {
                System.out.print(count[j][i] + " ");
            }
            System.out.println();
        }

    }

    void solve() {
        init();

        dp = new int[N+1]; // dp[i] = i번째 값까지 오븐을 누르는 수
        count = new int[N+1][5];

        bfs();

        for (int t = 0; t < n; t++) {
            int v = T[t] % 60;
            int n60 = T[t] / 60;
            count[v][0]+= n60; // 60으로 나눈 몫만큼 더해준다.
            for (int i = 0; i < 5; i++) {
                System.out.print(count[v][i] + " ");
            }
            System.out.println();
            count[v][0] -= n60; // 다시 빼준다.
        }


    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            T = new int[n];
            for (int i = 0; i < n; i++) {
                T[i] = Integer.parseInt(br.readLine());
            }

        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_19940_imp b = new B_19940_imp();
        b.solve();
    }
}
