package b_202412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B_23559 {

    int n, x;
    int[][] money;

    void solve() {

        // 일단 맛있는 걸 고른다.
        // 가장 맛의 차이가 적은 날부터 5천원일 경우에는 1000으로 바꿔준다. (-4000)
        int taste = 0, price = 0;
        boolean[] is5000 = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        for (int i = 0; i < n; i++) {
            if (money[i][0] > money[i][1]) {
                is5000[i] = true;
                price += 5000;
                taste += money[i][0];
                pq.add(new int[]{i, money[i][0] - money[i][1]});
            } else {
                price += 1000;
                taste += money[i][1];
            }
        }

        while (price > x) {
            int[] p = pq.poll();
            int idx = p[0];
            price -= 4000;
            taste -= money[idx][0];
            taste += money[idx][1];
        }

        System.out.println(taste);

    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            n = arr[0];
            x = arr[1];
            money = new int[n][2];
            for (int i = 0; i < n; i++) {
                money[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_23559 b = new B_23559();
        b.init();
        b.solve();
    }
}
