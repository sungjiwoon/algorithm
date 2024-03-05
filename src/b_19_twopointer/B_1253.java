package b_19_twopointer;

import java.io.*;
import java.util.*;
/** 240305 백준 좋다 골드 4 투 포인터 */
public class B_1253 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);

        int res = 0;
        for (int i = 0; i < n; i++) {
            int find = arr[i];
            int st = 0, en = n - 1;
            while (st < en) {
                long sum = arr[st] + arr[en];
                if (sum < find) {
                    st++;
                } else if (sum > find) {
                    en--;
                } else {
                    if (st != i && en != i) {
                        res++;
                        break;
                    }
                }
                if (st == i) {
                    st++;
                }
                if (en == i) {
                    en--;
                }

            }
        }
        System.out.println(res);

    }
}
