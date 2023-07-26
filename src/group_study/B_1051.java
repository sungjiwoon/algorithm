package group_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1051 {
    private static int solve(int n, int m, char[][] map) {
        int cmp = n>m ? m : n; //정사각형의 최대 크기는 n과 m 중 작은 값.

        for (int k = cmp-1; k >= 1; k--) { //최댓값부터 시작하여 줄여준다. k=변의길이-1
            for (int i = 0; i + k < n; i++) { //완전탐색 시작.
                for (int j = 0; j + k < m; j++) {
                    if (map[i][j] == map[i+k][j] && map[i+k][j] == map[i][j+k] && map[i][j+k] == map[i+k][j+k]) {
                        return (k+1) * (k+1);
                    }
                }
            }
        }
        return 1;
    }
    public void work() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        System.out.println("결과 : " + solve(n,m,map));

    }
}
