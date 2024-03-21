package b_16_greedy;

import java.io.*;
import java.util.*;
/** 240321 백준 1781 컵라면 그리디, 유니온파인드 */
public class B_1781 {
    static int[] parent;
    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        parent[x] = parent[y] = Math.min(x, y);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o2[1] == o1[1])
                return o1[0] - o2[0];
            return o2[1] - o1[1];
        }
        );
        for (int i = 0; i < n; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
            pq.add(arr);
        }

        long res = 0;
        while (!pq.isEmpty()) {
            int[] q = pq.poll();
            int day = q[0], cup = q[1];
            int find = find(day);
            if (find != 0) {
                res += cup;
                union(find, find-1);
            }
        }
        System.out.println(res);
    }
}
