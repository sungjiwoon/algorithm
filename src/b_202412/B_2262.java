package b_202412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 250127 토너먼트 만들기 그리디
public class B_2262 {
    int n;
    List<Integer> list = new ArrayList<>();

    void solve() {

        // 제일 낮은 것부터 찾음
        int max = n;
        int sum = 0;
        while (max > 1) {
            int idx = list.indexOf(max);
            int diff = max;

            // 왼쪽 or 오른쪽 살펴본 후 차이가 안나는 값을 고르기
            if (idx - 1 >= 0) {
                diff = Math.min(diff, max - list.get(idx - 1));
            }

            if (idx + 1 < list.size()) {
                diff = Math.min(diff, max - list.get(idx + 1));
            }
            sum += diff;
            list.remove(idx);
            max--;
        }

        System.out.println(sum);
    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            String[] sp = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(sp[i]));
            }
            solve();

        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_2262 b = new B_2262();
        b.init();
    }
}
