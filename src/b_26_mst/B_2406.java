package b_26_mst;

import java.io.*;
import java.util.*;

/** 240317 백준 2406 안정적인 네트워크 MST 실패 */
public class B_2406 {
    int n, m;
    int[] parent;
    int[][] edge;


    private int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    private StringBuilder solve() {
        StringBuilder sb = new StringBuilder();

        Arrays.sort(edge, (o1, o2) -> o1[2] - o2[2]);
        long x = 0; // 최소 비용
        int k = 0; // 쌍
        List<int[]> pair = new ArrayList<>();
        for (int i = 0; i < edge.length; i++) {
            if (find(edge[i][0]) != find(edge[i][1])) {
                x += edge[i][2];
                k++;
                pair.add(new int[]{edge[i][0], edge[i][1]});
                union(edge[i][0], edge[i][1]);
            }
        }

        sb.append(x+" "+k+"\n");
        for (int[] p : pair) {
            sb.append(p[0] + " " + p[1] + "\n");
        }
        return sb;

    }

    public static void main(String[] args) throws Exception {
//        Main b = new Main();
        B_2406 b = new B_2406();
        b.input();
        System.out.println(b.solve());

    }

    private void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            parent = new int[n+1];
            for (int i = 1; i   <= n; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                parent[a] = parent[b] = Math.min(parent[a], parent[b]);

            }


            int[][] cost = new int[n][n];
            for (int i = 0; i < n; i++) {
                cost[i] = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
            }

            edge = new int[n*(n-1)/2 - (n-1)][3];
            int idx = 0;
            for (int i = 1; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    edge[idx][0] = i+1;
                    edge[idx][1] = j+1;
                    edge[idx][2] = cost[i][j];
                    idx++;
                }

            }



        } catch (Exception e) {}
    }
}
