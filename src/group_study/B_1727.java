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

    public void work() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String lng = "", srt = "";
        if (n > m) {
            lng = br.readLine();
            srt = br.readLine();
        } else {
            srt = br.readLine();
            lng = br.readLine();
        }

        st = new StringTokenizer(srt, " ");
        int size_srt = st.countTokens();
        int[] men = new int[size_srt+1];
        for (int i = 1; i <= size_srt; i++) men[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(lng, " ");
        int size_lng = st.countTokens();
        int[] women = new int[size_lng+1];
        for (int i = 1; i <= size_lng; i++) women[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(men);
        Arrays.sort(women);


        //일단 n이 더 작다고 가정하여 문제 풀음.
        int[][] dp = new int[1002][1002];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i <= size_srt; i++) {
            for (int j = i; j <= size_lng-size_srt+i; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i-1; k <= j-1; k++) {
                    min = Math.min(min, dp[i-1][k]);
                    //System.out.println("compare " + women[j] + " :: " + dp[i-1][k]);
                }
                //if (min == Integer.MAX_VALUE) min = 0;
                dp[i][j] = min + Math.abs(men[i]-women[j]);
                //System.out.println(men[i] + " " + women[j] + ": " + dp[i][j]);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= size_lng; i++) {
            ans = Math.min(dp[size_srt][i], ans);
        }

        System.out.println(ans);


    }
}
