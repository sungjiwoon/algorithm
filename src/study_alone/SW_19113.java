package study_alone;

import java.io.*;
import java.util.*;
/** 240412 SWAT 19113 */
public class SW_19113 {
    int TC;
    int n;
    int[] list, res;

    public void solve() {
        res = new int[n];
        boolean[] vis = new boolean[n * 2];
        int idx = 0;

        for (int i = 0; i < n * 2; i++) {
            if (vis[i]) continue;
            int price = list[i];
            int p3 = price/3;
            for (int j = i + 1; j < n * n; j++) {
                if (!vis[j] && p3 * 4 == list[j]) {
                    vis[j] = true;
                    break;
                }
            }
            res[idx++] = price;
        }

    }




    public static void main(String[] args) throws Exception {
        SW_19113 s = new SW_19113();
        s.input();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        TC = Integer.parseInt(br.readLine());
        for (int t = 1; t <= TC; t++) {
            n = Integer.parseInt(br.readLine());
            list = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            solve();
            sb.append("#"+t+" ");
            for (int v : res) {
                sb.append(v + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
