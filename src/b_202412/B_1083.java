package b_202412;

import java.io.*;
import java.util.*;
/** 240124 소트 그리디 버블정렬 */
public class B_1083 {

    int n, s;
    int[] a;

    void solve() {
        init();

        // 버블 소트 응용 : 버블 소트 - 가장 큰값을 맨뒤로 보내면서 정렬하는 방법

        for (int i = 0; i < n; i++) {
            if (s <= 0) break;
            // i번째 자리에는 (i+1 ~ n-1) 중 a[i]보다 가장 큰 값이 온다., 단 올 수 있는 값만 온다. (거리가 s이내)
            int max = a[i], maxIdx = i;
            for (int j = i+1; j < n; j++) {
                if (j-i > s) break;

                if (a[j] > max) {
                    max = a[j];
                    maxIdx = j;
                }
            }

            // maxIdx까지 swap 처리
            for (int j = maxIdx; j > i; j--) {
                swap(j, j-1);
            }
            s -= (maxIdx - i);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }

    }

    void swap (int idx1, int idx2) {
        int tmp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = tmp;
    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            s = Integer.parseInt(br.readLine());
        } catch (Exception e) {}
    }
    public static void main(String[] args) {
        B_1083 b = new B_1083();
        b.solve();
    }
}
