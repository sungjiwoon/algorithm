package b_202412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 250113 행복 유치원 (그리디) gold5
public class B_13164 {
    int n, k;
    int[] kids;

    void solve() {
        init();

        int[] values = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            values[i] = kids[i+1]-kids[i];
        }

        Arrays.sort(values);

        // n-1개의 간격이 나옴. 정렬함
        // 간격이 넓은 순으로 기준이 되어 그룹이 나뉘어짐
        // k개의 그룹은 k-1개의 기준이 필요함
        // (n-1)개 간격 - (k-1) 기준 = n - k개 만큼의 값을 더해주면 됨
        int res = 0;
        for (int i = 0; i < n - k; i++) {
            res += values[i];
        }

        System.out.println(res);


    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            n = tmp[0];
            k = tmp[1];
            kids = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_13164 b = new B_13164();
        b.solve();
    }
}
