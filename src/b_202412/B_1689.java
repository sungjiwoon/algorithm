package b_202412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/** 240125 겹치는 선분 그리디, 스위핑, 정렬 */
public class B_1689 {
    int n;
    int[][] points;

    void solve() {

        // 처음부터 끝까지 단 한 번만 탐색해서 구하는 기법인 스위핑을 사용한다.
        //스위핑을 위해서, 입력받는 선분을 파싱하여 저장한다.
        //시작점은 +1 을 붙여서, 끝점은 -1을 붙여서 저장한다. [[스위핑- +1 -1 테크닉]]
        //저장한 점들을 정렬한다.
        //정렬된 점들을 하나씩 읽어가면서, +1 또는 -1을 가지고 누적합을 계산한다.
        //누적합이 바로 겹쳐있는 선분의 개수이다.
        //점을 하나씩 볼 때마다 정답을 갱신해주면 된다.

        Arrays.sort(points, (o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0]-o2[0];
            return o1[1]-o2[1]; // 끝점이 겹칠 경우 끝점 먼저 계ㅅ산해야함 (겹치는 지점은 포함X이므로)

        });

        int sum = 0;
        int max = 0;
        for (int i = 0; i < 2*n; i++) {
            sum += points[i][1];
            max = Math.max(sum, max);
        }
        System.out.println(max);


    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            points = new int[2*n][2];
            for (int i = 0; i < n; i++) {
                int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                points[i*2] = new int[] {tmp[0], 1};
                points[i*2+1] = new int[] {tmp[1], -1};
            }
            solve();
        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_1689 b = new B_1689();
        b.init();
    }
}
