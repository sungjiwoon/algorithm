package study_alone;

import java.io.*;
import java.util.*;

/** 240310 백준 텀 프로젝트 골드 3 DFS */

public class B_9466 {

    int[] arr;
    int[] state;
    boolean[] vis;
    // 0 : 아직 확인 안함, 1: 확인 했는데 순환구조 아님, 2 : 확인도 하고 순환도 맞음.

    private void checkCircle(int st) {
        int nxt = arr[st];
        while (state[nxt] == 0) {
            System.out.println(String.format("=>> state[%d] = 2", nxt));
            state[nxt] = 2;
            nxt = arr[nxt];
        }
    }

    private void dfs(int st) {

        if (state[st] >= 1) {
            return;
        }

        if (vis[st]) {
            checkCircle(st);
            return;
        }

        vis[st] = true;
        dfs(arr[st]);
        if (state[st] != 2) {
            System.out.println(String.format("state[%d] = 1", st));
            state[st] = 1;
        }

    }

    private void input() throws Exception {
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
            arr = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(tokenizer.nextToken());
            }

            state = new int[n + 1];
            int cnt = 0;
            vis = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {

                dfs(i);
                if (state[i] == 1) cnt++;
            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {

        B_9466 b = new B_9466();
//        Main b = new Main();
        b.input();
    }
}