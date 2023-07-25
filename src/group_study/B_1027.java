package group_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1027 {
    static long[] data;
    static int[] ans;
    static int n;
    private static void func() {
        /*
        건물 a,b가 보이는 조건
        a를 기준으로 그 전 건물(b-1)의 기울기보다 커야 보인다.
        기울기 구하는 공식 : b의 높이 - a의 높이 / b의 위치 - a의 위치

        한방향으로 검사해도 양방향과 같은 값이 나온다.
         */

        for (int i = 1; i < n; i++) {
            ans[i]++; //바로 옆건물은 보이니 1 더해줌.
            ans[i+1]++;
            double icl = data[i+1] - data[i];
            for (int j = i+2; j <= n; j++) {
                double nxt_icl = (double)(data[j] - data[i]) / (j - i);
                if (nxt_icl <= icl) continue;
                icl = nxt_icl;
                ans[i]++;
                ans[j]++;
            }
        }
    }
    public void work() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        data = new long[n + 1];
        ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        func();
        Arrays.sort(ans);
        System.out.println(ans[n]);

    }
}
