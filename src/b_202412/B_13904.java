package b_202412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.PropertyResourceBundle;

/** 240201 과제 그리디 */
public class B_13904 {
    int n;
    int[][] works;
    void solve() {

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) ->
            {
                if (o1[1] != o2[1]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        );

        for (int i = 0; i < n; i++) {
            pq.add(new int[] {works[i][0], works[i][1]});
        }

        boolean[] days = new boolean[1001];
        int sum = 0;
        while (!pq.isEmpty()) {
            int[] q = pq.poll();
            int d = q[0], s = q[1];
            for (int i = d; i >= 1; i--) {
                if (!days[i]) {
                    days[i] = true;
                    sum += s;
                    break;
                }
            }
        }
        System.out.println(sum);
    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            works = new int[n][2];
            for (int i = 0; i < n; i++) {
                works[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            solve();

        } catch (Exception e) {}
    }
    public static void main(String[] args) {
        B_13904 b= new B_13904();
        b.init();
    }
}
