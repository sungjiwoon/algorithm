package b_16_greedy;

import java.io.*;
import java.util.*;
/** 240321 백준 2437 저울 그리디 */
public class B_2437 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(arr);

        long sum = arr[0];
        for (int i = 1; i < n; i++) {
            if (sum + 1 < arr[i]) break;
            sum += arr[i];
        }
        System.out.println(sum+1);


    }
}
