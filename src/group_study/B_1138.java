package group_study;

import java.io.*;
import java.util.*;

public class B_1138 {
    static int n;
    static int[] data, res;
    static void solve() {
        for (int i = 0; i < n; i++) {
            int k = 0;
            for (int j = 0; j < n; j++) {
                if (res[j] != 0) continue;
                if (k == data[i]) {
                    res[j] = i+1;
                    break;
                }
                k++;
            }
        }

    }
    public void work() throws IOException {

        input(new BufferedReader(new InputStreamReader(System.in)));

        solve();

        for (int i = 0; i < n; i++) System.out.print(res[i] + " ");

    }
    private static void input(BufferedReader br) throws IOException {
        n = Integer.parseInt(br.readLine());
        data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        res = new int[n];
    }
}
