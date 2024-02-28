package hell_study;

import java.io.*;
import java.util.*;

/**
 * 240228 백준 멀티버스2 골드 5 정렬, 수학
 */
public class B_18869 {
    int n, m;
    List<Pair>[] space;
    int res = 0;

    class Pair {
        int idx, v;
        Pair (int idx, int v) {
            this.idx = idx;
            this.v = v;
        }
    }

    /*
    균등한 우주의 갯수를 구한다.
    2중 탐색 필수
    시간 복잡도 최악 O(M제곱*N) = m * m * n= 100 * 100 * 10000번

     */

    private boolean compare(int a, int b) {
        for (int i = 0; i < n; i++) {
            if (i >= 1 && space[a].get(i).v == space[a].get(i-1).v) {
                if (space[b].get(i).v != space[b].get(i-1).v) return false;
            }
            if (space[a].get(i).idx != space[b].get(i).idx) return false;
        }
        return true;
    }

    private void solve() {

        boolean[] vis = new boolean[m]; // 시간 초과 대비
        for (int i = 0; i < m; i++) {
            if (vis[i]) continue; // 이미 검사 완료된건 통과
            int cnt = 1;
            for (int j = i + 1; j < m; j++) {
                // 우주 2개 비교
                if (compare(i, j)) {
                    vis[i] = true;
                    vis[j] = true;
                    cnt++;
                }
            }
            res += cnt * (cnt -1) / 2; // 만약 i번쨰 우주와 같은 우주의 갯수가 2개라면 3C2 가 된다.
        }
    }
    public static void main(String[] args) {
        B_18869 b = new B_18869();
//        Main b = new Main();
        b.input();
        b.solve();
        System.out.println(b.res);
    }

    private void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            m = tmp[0];
            n = tmp[1];
            space = new ArrayList[m];
            for (int i = 0; i < m; i++) {
                tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                space[i] = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    space[i].add(new Pair(j, tmp[j]));
                }

                Collections.sort(space[i], (o1, o2) -> o1.v - o2.v);
            }
        } catch (Exception e) {}
    }

}
