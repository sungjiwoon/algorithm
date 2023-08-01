package group_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B_1034 {
    static HashMap<String, Integer> patterns = new HashMap<>();
    static int n,m,k;
    static String[] map;
    private static int solve() {
        int max = 0;
        for (int i = 0; i < n; i++) {

            if (patterns.containsKey(map[i])) {
                patterns.put(map[i], patterns.get(map[i])+1);
            } else {
                patterns.put(map[i], 1);
            }

            //각 줄마다 0의 갯수를 구한다.
            int zero = 0;
            for (int j = 0; j < m; j++) {
                if ( map[i].charAt(j) == '0') zero++;
            }

            if (k % 2 == 0 && zero % 2 == 0 && zero <= k) {
                max = Math.max(max, patterns.get(map[i]));
            } else if (k % 2 == 1 && zero % 2 == 1 && zero <= k) {
                max = Math.max(max, patterns.get(map[i]));
            }

        }
        return max;
    }
    public void work() throws IOException {

        input(new BufferedReader(new InputStreamReader(System.in)));
        System.out.println(solve());

        /*
        k가 홀수일 때, 짝수일 때 답이 다르다.
        홀수이면, 무조건 하나 이상의 홀수개의 열이 바껴야하고,
        짝수이면, 그대로 두거나, 2개이상의 짝수개의 열이 바껴야한다.

        최대한 많은 행의 불이 켜져있을려면
        가장 많은 행의 패턴의 갯수를 구하면 된다.

        한 행에서 0의 갯수를 구한다음,
        0의 갯수가 k의 짝수,홀수 여부에 맞는지,
        k보다 작거나 같은지 판단하고,
        그러한 행들 중 가장 많은 갯수를 가진 행을 구하면 된다.

         */

    }
    private static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new String[n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine();
        }

        k = Integer.parseInt(br.readLine());
    }
}
