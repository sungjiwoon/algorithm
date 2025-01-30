package b_202412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/** 240130 우체국 그리디  */
public class B_2141 {
    int n;
    int[][] d;

    void solve() {

        // 인구 수 기준으로 인구의 중간값보다 큰 값이어야함
        // 거리는 우체국 기준 왼 , 오른쪽이 동일해야함
        // 우체국 지점 기준으로 왼, 오른쪽의 사람 수가 중간 값과 비슷하면 됨

        // 왼, 오 구하는 방법

        // 일단 배열을 거리 순으로 정렬한다.
        Arrays.sort(d, (o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0]-o2[0];
            return o2[1]-o1[1];
        });


        long[] peoples = new long[n];
        peoples[0] = d[0][1];
        for (int i = 1; i < n; i++) {
            peoples[i] = peoples[i-1] + d[i][1];
        }

        // 거리 순으로 할 때 왼쪽이 현저하게 적으므로,
        // 왼쪽의 사람 수가 오른쪽의 사람 수보다 같거나 많아지는 첫번째 지점이
        // 거리순 최소이다.

        int res = 0;
        for (int i = 0; i < n; i++) {
            long l = peoples[i] - d[i][1]; // 왼쪽 인구수
            long r = peoples[n-1] - peoples[i]; // 오른쪽 인구수
            if (l >= r) {
                res = d[i][0];
                break;
            }
        }
        System.out.println(res);


    }


    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());

            d = new int[n][2];
            for (int i = 0; i < n; i++) {
                String[] sp = br.readLine().split(" ");
                d[i][0] = Integer.parseInt(sp[0]);
                d[i][1] = Integer.parseInt(sp[1]);
            }

            solve();

        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_2141 b = new B_2141();
        b.init();
    }
}
