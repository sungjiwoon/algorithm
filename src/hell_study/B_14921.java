package hell_study;

import java.io.*;
import java.util.*;

/** 240305 백준 용액 합성하기 골드 5 투포인터 */

public class B_14921 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int res = Integer.MAX_VALUE;
        int b = 0;
        int st = 0, en = n - 1;

        while (st < en) {
            int sum = arr[st] + arr[en];
            if (sum < 0) {
                st++;
            } else if (sum > 0) {
                en--;
            } else {
                b = 0;
                break;
            }
            if (res > Math.abs(sum)) {
                b = sum;
                res = Math.abs(sum);
            }
        }

        System.out.println(b);

    }
}
