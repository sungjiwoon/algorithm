package study_alone;

import java.util.*;
import java.io.*;

/** 240324 백준 10986 나머지 합 골드 3 누적합 */
public class B_10986 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Map<Long, Long> map = new HashMap<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long[] prefix = new long[n];
        prefix[0] = arr[0];
        map.put(prefix[0] % m, 1L);
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] + arr[i];
            // prefix[i] 는 i번 째의 누적합.
            long key = prefix[i] % m;
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1L);
            }
        }

        long res = 0;
        for (long key : map.keySet()) {
            long v = map.get(key);
            if (key % m == 0) res += v;// i == j도 포함이다.
            res += v * (v-1) / 2; // vC2 더한 값이다.
        }
        System.out.println(res);
    }
}
