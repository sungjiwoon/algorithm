package b_202502;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class B_14658 {

    int n, m, l, k;
    int[][] stars;

    private void solve() {

        int cnt = 0;

        Arrays.sort(stars, (o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0]-o2[0];
            return o1[1]-o2[1];
        });

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                int x = stars[i][0];
                int y = stars[j][1];

                int sum = 0;
                for (int r = 0; r < k; r++) {
                    int cx = stars[r][0], cy = stars[r][1];
                    if (cx >= x && cx <= x+l && cy >= y && cy <= y+l) sum++;
                }
                cnt = Math.max(cnt, sum);

            }
        }
        int value = k-cnt;
        System.out.println(value);

    }


    private void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            stars = new int[k][2];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                stars[i][0] = Integer.parseInt(st.nextToken());
                stars[i][1] = Integer.parseInt(st.nextToken());
            }
            solve();

        } catch (Exception e) {}
    }
    public static void main(String[] args) {
        B_14658 b = new B_14658();
        b.init();

    }
}
