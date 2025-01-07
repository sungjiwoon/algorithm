package b_202412;

import java.io.*;
import java.util.Arrays;


public class B_11509 {
    int n;
    int[] arr;

    void solve() {
        int cnt = 0;

        int[] hArr = new int[1000001];

        for (int i = 0; i < n; i++) {
            // 높이 별 체크
            // 해당 높이에 쏠 수 있는 화살이 없음.
            if (hArr[arr[i]] == 0) {
                cnt++; // 화살 1개 생성
                hArr[arr[i]-1]++; // 화살은 높이 낮은 으로 이동
            } else {
                hArr[arr[i]]--;
                hArr[arr[i]-1]++;
            }
        }
        System.out.println(cnt);
    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_11509 b = new B_11509();
        b.init();
        b.solve();
    }


}
