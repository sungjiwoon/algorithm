package b_202412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 240131 일감호에 다리 놓기 최소스패닝트리 */
public class B_17490 {
    int n, m;
    long k;
    int[] s;
    int[] parents;
    boolean[] isBlocked;

    int find(int a) {
        if (parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (s[a] <= s[b]) parents[b] = a; //비용이 더 적은 걸로 이어준다.
        else parents[a] = b;
    }

    void solve() {
        parents = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        // 일단 각 건물들이 바라보는 방향이 1인지 확인한다. 단 공사중이면 합치지 않음.
        for (int i = 1; i <= n; i++) {
            int u = i;
            int v = i+1;
            if (v == n+1) {
                // n 다음은 1이므로.
                u = 1;
                v = n;
            }
            if (find(u) != find(v)) {
                if (isBlocked[v]) continue;
                union(u, v);
            }
        }

//        for (int i = 1; i <= n; i++) {
//            System.out.print(parents[i] + " ");
//        }

        // 그룹이 생성될 것이다. > 그룹 별로 작은 비용을 뽑아 더해준다.

        // parents[i]의 값이 최소이다.
        int parentCnt = 0; // 부모가 1개이면 굳이 할필요 없음.
        for (int i = 1; i <= n; i++) {

            if (parents[i] == i) {
                k -= s[parents[i]];
                parentCnt++;
            }
        }

        if (k >= 0 || parentCnt <= 1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }


    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer ti = new StringTokenizer(br.readLine(), " ");

            n = Integer.parseInt(ti.nextToken());
            m = Integer.parseInt(ti.nextToken());
            k = Long.parseLong(ti.nextToken());
            s = new int[n+1];

            ti = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i <= n; i++) {
                s[i] = Integer.parseInt(ti.nextToken());
            }

            isBlocked = new boolean[n+1];
            for (int i = 0; i < m; i++) {
                ti = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(ti.nextToken());
                int b = Integer.parseInt(ti.nextToken());
                if (a > b) isBlocked[a] = true;
                else isBlocked[b] = true;
            }

            solve();
        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_17490 b = new B_17490();
        b.init();
    }
}
