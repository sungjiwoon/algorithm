package b_19_twopointer;

import java.util.*;
import java.io.*;
/** 240324 백준 구간자르기 누적합, 투포인터 */
public class B_2283 {
    static final int INF = 1000002;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] line = new long[INF];
        int s, e;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            line[s]++;
            line[e]--; // 끝점이므로.
        }

        long[] prefix = new long[INF]; //누적합 //prefix[i] = i번에 있는 선의 갯수.
        for (int i = 0; i < INF - 1; i++) {
            prefix[i+1] = prefix[i] + line[i];
        }

        // 투 포인터
        int a = 1, b = 1;
        long sum = prefix[1];
        boolean ok = false;
        while (true) {
            if (sum < k) {
                b++;
                if (b == INF) {
                    break;
                }
                sum += prefix[b];
            } else if (sum > k) {
                sum -= prefix[a];
                a++;
                if (a == INF) {
                    break;
                }
            } else {
                ok = true;
                break;
            }
        }
        if (ok) {
            System.out.println((a-1) + " " + b);
        } else {
            System.out.println("0 0");
        }



    }
}
