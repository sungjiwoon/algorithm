package b_15_dp;

import com.sun.tools.javac.Main;
import java.util.*;
import java.io.*;

public class B_2240 {
    int T, W;
    int[] dp, info;
    int res;
    private void solve() {

    }

    public static void main(String[] args) {
        B_2240 m = new B_2240();
//        Main m = new Main();
        m.input();
        m.solve();

        System.out.println(m.res);

    }

    private void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
            T = tmp[0];
            W = tmp[1];
            info = new int[T];
            for (int i = 0; i < T; i++) {
                info[i] = Integer.parseInt(br.readLine());
            }
        } catch (Exception e) {}

    }
}
