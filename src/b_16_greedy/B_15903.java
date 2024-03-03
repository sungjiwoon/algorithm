package b_16_greedy;

import java.io.*;
import java.util.*;

/**
 * 240303 백준 카드합체놀이 그리디 실버 1
 */
public class B_15903 {

    static int n, m;
    static int[] arr;

    private static long play() {

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (long num : arr) {
            pq.add(num);
        }

        for (int i = 0; i < m; i++) {
            long x = pq.poll();
            long y = pq.poll();

            long sum = x + y;
            pq.add(sum);
            pq.add(sum);
        }

        long res = 0;
        while (!pq.isEmpty()) {
            res += pq.poll();
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(play());
    }

    private static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    }
}