package b_202502;

import java.io.*;
import java.util.*;
// 250207 소프티어 사물인식 최소 면적 산출 프로그램
// 백트래킹이되, 면적의 크기를 계산할 때 사이즈 비굘르 통해 효율적으로 계산하자
public class Softeer_1 {

    List<Pair>[] pairs;
    int n, k;
    int sum = Integer.MAX_VALUE;

    class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    void dfs(int depth, int x1, int x2, int y1, int y2) {
        if (depth > k) {

            int size = Math.abs(x2-x1) * Math.abs(y2-y1);
            // System.out.println(x1 + " " + x2 + " " + y1 + " " + y2 + "=" + size);
            sum = Math.min(size, sum);
            return;
        }

        int tx1 = x1, tx2 = x2, ty1 = y1, ty2 = y2;
        for (Pair p : pairs[depth]) {

            x1 = Math.min(tx1, p.x);
            y1 = Math.min(ty1, p.y);
            x2 = Math.max(tx2, p.x);
            y2 = Math.max(ty2, p.y);
            int size = Math.abs(x2-x1) * Math.abs(y2-y1);
            if (size < sum) dfs(depth+1, x1, x2, y1, y2);

        }

    }

    void solve() {

        for (Pair p : pairs[1]) {
            int x1 = p.x;
            int y1 = p.y;
            int x2 = p.x;
            int y2 = p.y;
            dfs(2, x1, x2, y1, y2);
        }

        System.out.println(sum);


    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            pairs = new ArrayList[k+1];
            for (int i = 1; i <= k; i++) {
                pairs[i] = new ArrayList<>();
            }

            for (int i = 0; i < n; i++) {
                int[] spots = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                pairs[spots[2]].add(new Pair(spots[0], spots[1]));
            }

            solve();
        } catch (Exception e){}
    }

    public static void main(String[] args) throws Exception {
        Softeer_1 b = new Softeer_1();
        b.init();


    }
}

