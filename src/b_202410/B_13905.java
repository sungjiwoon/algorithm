package b_202410;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/** 241013 세부 (골드4) 크루스칼 */
public class B_13905 {
    int n, m, s, e;
    int[] parent;
    int[][] map;

    int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x < y) parent[y] = x;
        else parent[x] = y;
    }

    public void solve() {
        // 1. 정렬 (비용 기준 최댓값)
        Arrays.sort(map, (o1, o2) -> o2[2] - o1[2]);

        // 2. 유니온 파인드
        parent = new int[n+1];
        List<int[]>[] costs = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            costs[i] = new ArrayList<int[]>();
        }

        int min = 0;
        for (int i = 0; i < m; i++) {
            int x = map[i][0], y = map[i][1], cost = map[i][2];
            int px = find(parent[x]);
            int py = find(parent[y]);
            if (px != py) {
                union(px, py);
                if (find(s) == find(e)) { // s와 e가 연결되는 지점의 최솟값
                    min = cost;
                    break;
                }
            }
        }
        System.out.println(min);
    }

    public static void main(String[] args) throws Exception {
        B_13905 b = new B_13905();
        b.init();
        b.solve();
    }

    public void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = tmp[0];
        m = tmp[1];
        tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        s = tmp[0];
        e = tmp[1];
        map = new int[m][3];

        for (int i = 0; i < m; i++) {
            tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map[i] = tmp;
        }
    }
}
