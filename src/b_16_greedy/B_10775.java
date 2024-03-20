package b_16_greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/** 240320 백준 공항 그리디, 유니온 파인드 */

// g번 게이트 차 있으면 g-1게이트 -> g-2게이트 -> g-3게이트 -> .. 0번 게이트까지 봐야함.
public class B_10775 {
    static int G, P;
    static int[] list;
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

    private static int solve() {
        int res = 0;
        parent = new int[G + 1];
        for (int i = 1; i <= G; i++) parent[i] = i;

        for (int i = 0; i < P; i++) {
            // 만약 자리가 비어져 있는 곳이 남아있다면 0 < parent[idx] <= idx 를 반환할 것이다.
            int idx = find(list[i]);

            if (idx == 0) return res; // 0이면 게이트 남는 자리 없음.
            union(idx, idx - 1); //합친다. 한숫자 작은 수로 이동 idx는 이제 사용할 수 없으므로. 
            res++;

        }

        return res;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());

        list = new int[P];
        for (int p = 0; p < P; p++) {
            list[p] = Integer.parseInt(br.readLine());
        }

        System.out.println(solve());
    }
}
