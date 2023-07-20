package group_study;
import java.io.*;
import java.util.*;
/*
문제 : 커플만들기 (골2)
소요시간 : 2시간 걸려 성공 ㅜ
시간 제한 : 2초
메모리 : 128
 */
public class B_1727 {
    private static int func(int[] large, int[] small, int lg_size, int sm_size) {

        //일단 n이 더 작다고 가정하여 문제 풀음.
        int[][] dp = new int[1002][1002];

        for (int i = 1; i <= sm_size; i++) {
            for (int j = 1; j <= lg_size; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i <= sm_size; i++) {
            for (int j = i; j <= lg_size-sm_size+i; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i-1; k <= j-1; k++) {
                    min = Math.min(min, dp[i-1][k]);
                }
                dp[i][j] = min + Math.abs(small[i]-large[j]);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= lg_size; i++) {
            ans = Math.min(dp[sm_size][i], ans);
        }
        return ans;
    }
    public void work() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] men = new int[n+1];
        for (int i = 1; i <= n; i++) men[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] women = new int[m+1];
        for (int i = 1; i <= m; i++) women[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(men);
        Arrays.sort(women);

        int ans = 0;
        if (n > m) ans = func(men, women, n, m);
        else ans = func(women, men, n, m);

        System.out.println(ans);


    }
}

/*
    최대한 많은 커플을 만드는 것이 중요하므로, 여자와 남자 집단 중 작은 집단을 기준으로 모두가 커플이 되어야한다.
    그래서 func에서는 인원수가 큰집단과 작은집단으로 나누어 풀었다.
    dp[i][j] = 작은집단[i]와 큰집단[j]가 커플일 때의 성격차이 합의 최소를 저장한다.
    dp[i][j] = dp[i-1][(i-1) ~ (j-1)]의 최소 + small[i]-large[j];

    범위를 (i-1) ~ (j-1) 로 지정한 이유는
    예를 들어
    small group : 4 5 8 20
    large gorup : 1 1 1 4 5 7 9
    일 때
    dp[4(=20)][7(=9)] = dp[3][3(=1) ~ 6(=7)] + (small[4]-large[7])



 */










