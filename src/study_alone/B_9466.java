package study_alone;

import java.io.*;
import java.util.*;

/** 240310 백준 텀 프로젝트 골드 3 DFS */

public class B_9466 {

    static int T, n;
    static int[] arr;
    static int[] state; // 0 : 아직 확인 안함, 1: 확인 했는데 순환구조 아님, 2 : 확인도 하고 순환도 맞음.

    private static void checkCircle(int st) {
        int nxt = arr[st];
        while (state[nxt] == 0) {
            System.out.println(String.format("=>> state[%d] = 2", nxt));
            state[nxt] = 2;
            nxt = arr[nxt];
        }
    }

    private static void dfs(int st, boolean[] vis) {

        if (state[st] >= 1) {
            return;
        }

        if (vis[st]) {
            checkCircle(st);
            return;
        }

        vis[st] = true;
        dfs(arr[st], vis);
        if (state[st] != 2) {
            System.out.println(String.format("state[%d] = 1", st));
            state[st] = 1;
        }

    }

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());

            StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
            arr = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(tokenizer.nextToken());
            }

            state = new int[n + 1];

            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                boolean[] vis = new boolean[n + 1];
                dfs(i, vis);
                if (state[i] == 1) cnt++;
            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb);

    }
}