package b_16_greedy;

import java.io.*;
import java.util.*;

public class B_1082 {

    private static int compareMax(String x, String y) {
        int lenX = x.length();
        int lenY = y.length();

        if (y.equals("")) return 1;
        if (y.charAt(0) == '0') return 1;

        if (lenX > lenY) return 1;
        else if (lenX < lenY) return 2;

        for (int i = 0; i < lenX; i++) {
            if (x.charAt(i) > y.charAt(i)) return 1;
            else if (x.charAt(i) < y.charAt(i)) return 2;
        }

        return 0;
    }

    private static int compareString(String x, String y) {

        int lenX = x.length();
        int lenY = y.length();

        if (y.equals("")) return 1;

        if (lenX > lenY) return 1;
        else if (lenX < lenY) return 2;

        for (int i = 0; i < lenX; i++) {
            if (x.charAt(i) > y.charAt(i)) return 1;
            else if (x.charAt(i) < y.charAt(i)) return 2;
        }

        return 0;

    }
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] p = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        int m = Integer.parseInt(br.readLine());

        String[] map = new String[m+1];
        Arrays.fill(map, "");
        String max = "";

        for (int i = 0; i < n; i++) {
            for (int j = 0; j + p[i] <= m; j++) {

                if (i == 0) {
                    map[j + p[i]] = '0' + map[j];
                    System.out.println(map[j + p[i]]);
                    max = "0";
                    continue;
                }

                int com = compareString(i + map[j], map[j + p[i]]);
                if (com == 1) {
                    if (map[j].equals("")) map[j+p[i]] = String.valueOf(i);
                    else map[j + p[i]] = i + map[j];
                }

                com = compareMax(map[j + p[i]], max);
                if (com == 1) {
                    max = map[j + p[i]];
                }
            }
        }
        System.out.println(max);

    }
}
