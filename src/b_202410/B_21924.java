package b_202410;

import java.io.*;
import java.util.*;
/** 241013 최소스패닝트리 - 크루스칼 (유니온 파인드) */

public class B_21924 {
    int n, m;
    int[][] map;
    long priceSum = 0;
    int[] parent;

    int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }


    public void solve() {
        // 크루스칼 알고리즘 -> 유니온 파인드
        // 1. 비용 순 정렬 map[i][2] = cost
        Arrays.sort(map, (o1, o2) -> o1[2] - o2[2]);

        // 2. 노드 - 노드 합치기 단, 이미 연결된 노드라면 pass
        parent = new int[n+1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        int cost = 0;
        for (int i = 0; i < m; i++) {
            int x = map[i][0], y = map[i][1];
            if (find(parent[x]) != find(parent[y])) {
                cost += map[i][2];
                union(x, y);
            }
        }

        for (int i = 1; i <= n; i++) {
            find(i);
        }

        // 3. 비용 계산
        long res = priceSum - cost;

        // 4. 모든 건물이 이어져있는지 확인
        for (int i = 1; i < n; i++) {
            if (parent[i] != parent[i+1]) res = -1;
        }
        System.out.println(res);

    }

    public static void main(String[] args) throws Exception {
        B_21924 b = new B_21924();
        b.init();
        b.solve();
    }

    public void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = tmp[0];
        m = tmp[1];
        map = new int[m][3];

        for (int i = 0; i < m; i++) {
            tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map[i] = tmp;
            priceSum += tmp[2];
        }


    }
}
