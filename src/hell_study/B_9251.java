package hell_study;

import java.io.*;
/** 240227 백준 LCS DP 골드 5 */
public class B_9251 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();

        int[][] lcs = new int[1001][1001];
        int res = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {

                if (a[i] == b[j]) {
                    if (i-1 >= 0 && j-1 >= 0) lcs[i][j] = lcs[i-1][j-1] + 1;
                    else lcs[i][j] = 1;
                } else {
                    if (i-1 >= 0 && j-1 >= 0) lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                    else if (i == 0 && j-1 >= 0) lcs[i][j] = lcs[i][j-1];
                    else if (j == 0 && i-1 >= 0) lcs[i][j] = lcs[i-1][j];
                }

                res = Math.max(res, lcs[i][j]);
            }
        }

        System.out.println(res);

    }
}
