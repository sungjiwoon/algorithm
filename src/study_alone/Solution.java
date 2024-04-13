package study_alone;

import java.io.*;
import java.util.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    final int MAX_N = 203;
    int TC;
    int n;
    long[] list, res;


    public void solve() {
        res = new long[n];
        boolean[] vis = new boolean[MAX_N];
        int idx = 0;

        for (int i = 0; i < n * 2; i++) {
            if (vis[i]) continue;
            long price = list[i];
            long p3 = price/3;
            for (int j = i + 1; j < n * 2; j++) {
                if (!vis[j] && p3 * 4L == list[j]) {
                    vis[j] = true;
                    break;
                }
            }
            vis[i] = true;
            res[idx++] = price;
        }

    }



    public static void main(String args[]) throws Exception
    {
        Solution s = new Solution();
        s.input();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        TC = Integer.parseInt(br.readLine());
        for (int t = 1; t <= TC; t++) {
            n = Integer.parseInt(br.readLine());
            list = Arrays.stream(br.readLine().split(" "))
                    .mapToLong(Long::parseLong).toArray();
            solve();

            Arrays.sort(res);
            sb.append("#"+t+" ");
            for (long v : res) {
                sb.append(v + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}