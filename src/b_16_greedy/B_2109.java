package b_16_greedy;

import java.io.*;
import java.util.*;

/** 240321 백준 순회강연 그리디 골드3 */
public class B_2109 {
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
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
                if (o2[0] == o1[0]) return o1[1] - o2[1];
                return o2[0] - o1[0];
            }
        );
        for (int i = 0; i < n; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            pq.add(arr);
        }

        parent = new int[6];
        for (int i = 1; i <= 5; i++) parent[i] = i;

        long res = 0;

        while(!pq.isEmpty()) {
            int[] q = pq.poll();
            int cost = q[0];
            int day = q[1];
            int findDay = find(day);
            if (findDay != 0) {
                res += cost;
                System.out.println(findDay + ": " + cost);
                union(findDay, findDay-1);
                System.out.println(Arrays.toString(parent));
            }
        }

        System.out.println(res);
    }
}
