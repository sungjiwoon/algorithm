package b_202412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
/** 240120 난로 그리디 https://www.acmicpc.net/problem/15553 */

public class B_15553 {

    int n, k;
    int[] times;

    void solve() {
        init();

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1]-o1[1]);
        for (int i = 0; i < n-1; i++) {
            pq.add(new int[]{i, times[i+1]-times[i]});
        }

        int[] idx = new int[k-1];
        for (int i = 0; i < k-1; i++) {
            idx[i] = pq.poll()[0];
        }

        Arrays.sort(idx);
        int st = times[0], en=0;
        int sum = 0;
        for (int i = 0; i < k-1; i++) {
            en = times[idx[i]]+1;
            sum += (en - st);
            st = times[idx[i]+1];
        }
        en = times[n-1] + 1;
        sum += (en - st);
        System.out.println(sum);

    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            n = tmp[0];
            k = tmp[1];
            times = new int[n];
            for (int i = 0; i < n; i++) {
                times[i] = Integer.parseInt(br.readLine());
            }

        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_15553 b = new B_15553();
        b.solve();
    }
}
