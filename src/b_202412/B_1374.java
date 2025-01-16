package b_202412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class B_1374 {

    int n;
    int[][] classes = new int[100001][3];

    void solve() {
        init();

        Arrays.sort(classes, (o1, o2) -> {
            if (o1[1] != o2[1]) return o1[1]-o2[1];
            return o1[2]-o2[2];
        }); // 시작하는 시간 순으로
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 강의 끝나는 시간 담음
        pq.add(classes[0][2]);

        for (int i = 1; i < n; i++) {
            int st = classes[i][1], en = classes[i][2];

            int p = pq.peek();
            if (p <= st) pq.poll();
            pq.add(en);
        }

        System.out.println(pq.size());

    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            classes = new int[n][3];
            for (int i = 0; i < n; i++) {
                classes[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_1374 b = new B_1374();
        b.solve();
    }


}
